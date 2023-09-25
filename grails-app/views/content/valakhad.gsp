<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
    <asset:javascript src="sendMessage.js"/>
    <asset:javascript src="charsheet.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
    <asset:stylesheet href="table.css"/>
    <asset:stylesheet href="spell.css"/>
    <asset:stylesheet href="charsheet.css"/>
</head>
<body>
<g:render template="/navbar" />

<g:hiddenField name="target" id="target" value="${hook}"/>
<g:set var="statnames" value="${['STR', 'DEX', "CON", "INT", "WIS", "CHA"]}"/>
<g:set var="skillnames" value="${['Acrobatics', 'Animal Handling', 'Arcana', 'Athletics', 'Deception', 'History',
                                    'Insight', 'Intimidation', 'Investigation', 'Medicine', 'Nature', 'Perception',
                                    'Performance', 'Persuasion', 'Religion', 'Sleight of Hand', 'Stealth', 'Survival']}"/>
<g:set var="skillstats" value="${['1', '4', '3', '0', '5', '3', '4', '5', '3', '4', '3', '4', '5', '5', '3', '1', '1', '4']}"/>                              

<div role="main" class="homePage">
    <div class="mainMenu">
            <div style="align-items: left; width: 100%">
                <a href="/content">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>

            <%-- Header --%>
            <div style="display: flex; flex-direction: column">
                <div style="display: flex; flex-direction: horizontal">
                    <asset:image src="charart/valakhad.png" style="width: 120px; height: 120px; margin-right: 20px"/>
                    <div style="align-items: left; width: 50%; display: flex; flex-direction: column; margin-right: 5%">
                        <h1>${name}</h1>
                        <h3>${raceclass}</h3>
                    </div>

                    <div style="align-items: left; text-align: right; width: 50%; display: flex; flex-direction: column; margin-right: 5%">
                        <p>Experience: ${xp}</p>
                        <p>Next level at: ${nextxp}</p>
                    </div>             
                </div>
                <hr>
                
                <%-- Stats and Health --%>
                <div style="display: flex; flex-direction: horizontal">
                    <g:each in="${(0..<6)}">
                        <g:hiddenField name="stats${it}" id="stats${it}" value="/r d20+${(int)((stats[it]-10)/2)}"/>
                        <button class="charbtn" style="width: 80px; padding: 10px; margin: 10px; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="sendMessageTo('stats'+${it}, 'target')">
                            <div>${statnames[it]}</div>
                            <h4>+${(int)((stats[it]-10)/2)}</h4>
                            <div>(${stats[it]})</div>
                        </button>
                    </g:each>

                    <%-- Proficiency Bonus --%>
                    <g:hiddenField name="prof" id="prof" value="Proficiency: +${prof}"/>
                    <button class="charbtn" style="width: 80px; padding: 10px; margin: 10px; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="sendMessageTo('prof', 'target')">
                        <div>PROF</div>
                        <h4>+${prof}</h4>
                    </button>

                    <%-- Movement Speed --%>
                    <g:hiddenField name="speed" id="speed" value="Speed: ${speed} ft."/>
                    <button class="charbtn" style="width: 80px; padding: 10px; margin: 10px; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="sendMessageTo('speed', 'target')">
                        <div>Walking</div>
                        <h4>${speed} ft.</h4>
                        <div>Speed</div>
                    </button>
                    
                    <%-- Inspiration --%>
                    <button style="width: 90px; padding: 10px; margin: 10px; align-items: center; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="toggleInsp()">
                        <div>Inspiration</div>
                        <g:if test="${insp}">
                            <asset:image id="insp" src="inspiration.png" class="classBanner"/>
                        </g:if>
                        <g:else>
                            <asset:image id="insp" style="display: none" src="inspiration.png" class="classBanner"/>
                        </g:else>
                    </button>
                    
                    <%-- Health --%>
                    <div style="border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; align-items: center; background-color: gray; color: black" class="row">
                        <div class="col">
                            <button class="charbtn" style="color: green; margin: 5px" onclick="heal()">
                                <div>Heal</div>
                            </button>
                            <input type="number" name="hpchange" id="hpchange" style="width: 65px; margin-left: 6px" value="${0}"/>
                            <button class="charbtn" style="color: red; margin: 5px" onclick="damage()">
                                <div>Damage</div>
                            </button>
                        </div>

                        <div class="col">
                            <div>Current HP</div>
                            <input type="number" name="hp" id="hp" style="width: 65px; margin-left: 6px" value="${hp}"/>
                        </div>

                        <div class="col">
                            <div>Max HP</div>
                            <input type="number" name="maxhp" id="maxhp" style="width: 65px; margin-left: 6px" value="${maxhp}"/>
                        </div>

                        <div class="col">
                            <div>Temp HP</div>
                            <input type="number" name="temphp" id="temphp" style="width: 65px; margin-left: 6px" value="${temphp}"/>
                        </div>
                    </div>
                </div>  

                <%-- Main Body --%>
                <div class="row">

                    <%-- Left Column --%>
                    <div style="align-items: left; width: 20%; display: flex; flex-direction: column; margin-right: 2%">

                        <%-- Saves --%>
                        <div style="display: flex; flex-direction: horizontal; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; margin: 1%; background-color: grey; color: black">
                            <div style="display: flex; flex-direction: column; margin-left: 5%">
                                <g:each in="${(0..<3)}">
                                    <div style="display: flex; flex-direction: horizontal; margin: 5px">
                                        <g:hiddenField name="saves${it}" id="saves${it}" value="/r d20+${(int)((stats[it]-10)/2)+(prof * saves[it])}"/>
                                        <div style="margin-top: 15px">${statnames[it]}</div>
                                        <button class="charbtn" style="width: 40px; padding: 5px; margin: 5px" onclick="sendMessageTo('saves'+${it}, 'target')">
                                            <h4>+${(int)((stats[it]-10)/2)+(prof * saves[it])}</h4>
                                        </button>
                                    </div>
                                </g:each>
                                <g:each in="${(0..<savenotes.size())}">
                                    <p style="margin-left: 10px">${savenotes[it]}</p>
                                </g:each>
                            </div>
                            <div style="display: flex; flex-direction: column; margin-left: 15%">
                                <g:each in="${(3..<6)}">
                                    <div style="display: flex; flex-direction: horizontal; margin: 5px">
                                        <g:hiddenField name="saves${it}" id="saves${it}" value="/r d20+${(int)((stats[it]-10)/2)+(prof * saves[it])}"/>
                                        <div style="margin-top: 15px">${statnames[it]}</div>
                                        <button class="charbtn" style="width: 40px; padding: 5px; margin: 5px" onclick="sendMessageTo('saves'+${it}, 'target')">
                                            <h4>+${(int)((stats[it]-10)/2)+(prof * saves[it])}</h4>
                                        </button>
                                    </div>
                                </g:each>
                            </div>
                        </div>

                        <%-- Passives --%>
                        <div style="display: flex; flex-direction: horizontal; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; margin: 1%; margin-top: 5%; background-color: grey; color: black">
                            <div style="display: flex; flex-direction: column; margin: 3%">
                                <div style="display: flex; flex-direction: horizontal">
                                <h3>${10+(int)((stats[4]-10)/2)+prof*skills[11]}</h3>
                                <p style="margin-top: 0px; margin-left: 10px">Passive Wis (Perception)</p>
                                </div>
                                <div style="display: flex; flex-direction: horizontal">
                                <h3>${10+(int)((stats[3]-10)/2)+prof*skills[8]}</h3>
                                <p style="margin-top: 0px; margin-left: 10px">Passive Int (Investigation)</p>
                                </div>
                                <div style="display: flex; flex-direction: horizontal">
                                <h3>${10+(int)((stats[4]-10)/2)+prof*skills[6]}</h3>
                                <p style="margin-top: 0px; margin-left: 10px">Passive Wis (Insight)</p>
                                </div>
                                <g:if test="${!senses.isBlank()}">
                                    <p>${senses}</p>
                                </g:if>
                            </div>
                        </div>

                        <%-- Proficiencies and Languages --%>
                        <div style="display: flex; flex-direction: horizontal; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; margin: 1%; margin-top: 5%; background-color: grey; color: black">
                            <div style="display: flex; flex-direction: column; margin: 3%">
                                <h4>Armor</h4>
                                <p>${armor}</p>
                                <h4>Weapons</h4>
                                <p>${weapons}</p>
                                <h4>Tools</h4>
                                <p>${tools}</p>
                                <h4>Languages</h4>
                                <p>${languages}</p>
                            </div>
                        </div>
                    </div>

                    <%-- Skills --%>
                    <div style="align-items: left; width: 25%; display: flex; flex-direction: column; margin-right: 3%; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; background-color: grey; color: black; font-size: 11px">
                        <table style="border: none; border-radius: 15px">
                            <tr>
                                <th>PROF</th>
                                <th>MOD</th>
                                <th>SKILL</th>
                                <th>BONUS</th>
                            </tr>
                            <g:each in="${(0..<skillnames.size())}">
                                <tr>
                                    <g:if test="${skills[it] == 0}">
                                        <td>&#9675;</td>
                                    </g:if>
                                    <g:elseif test="${skills[it] == 0.5}">
                                        <td>&#9681;</td>
                                    </g:elseif>
                                    <g:elseif test="${skills[it] == 1}">
                                        <td>&#9679;</td>
                                    </g:elseif>
                                    <g:elseif test="${skills[it] == 2}">
                                        <td>&#9673;</td>
                                    </g:elseif>
                                    <td>${statnames[skillstats[it].toInteger()]}</td>
                                    <td>${skillnames[it]}</td>
                                    <g:hiddenField name="skills${it}" id="skills${it}" value=""/>
                                    <td>
                                        <button class="charbtn" style="width: 40px; font-size: 13px; margin-left: 10px" onclick="sendMessageTo('skills'+${it}, 'target')">
                                            <strong>+${(int)((stats[skillstats[it].toInteger()]-10)/2)+(prof * skills[it])}</strong>
                                        </button>
                                    <td>
                                </tr>
                            </g:each>
                        </table>
                    </div>

                    <div style="align-items: left; width: 50%; display: flex; flex-direction: column">


                        <div style="display: flex; flex-direction: horizontal; color: black">

                            <%-- Initiative --%>
                            <g:hiddenField name="init" id="init" value="/r d20+${initbonus + (int)((stats[1]-10)/2)}"/>
                            <button class="charbtn" style="width: 80px; padding: 10px; margin: 10px; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="sendMessageTo('init', 'target')">
                                <div>Initiative</div>
                                <h4>+${initbonus + (stats[1]-10)/2}</h4>
                            </button>

                            <%-- AC --%>
                            <g:hiddenField name="ac" id="ac" value="AC: ${ac}"/>
                            <button class="charbtn" style="width: 80px; padding: 10px; margin: 10px; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px" onclick="sendMessageTo('ac', 'target')">
                                <div>AC</div>
                                <h4>${ac}</h4>
                            </button>

                            <%-- Defences and Conditions --%>
                            <div style="width: 45%; background-color: gray; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; margin: 1%; text-align: center">
                                Defences
                                <p style="font-size: 9px; text-align: left; margin: 3px">${defences}</p>
                            </div>
                            <div style="width: 45%; background-color: gray; border: solid; border-color: darkred; border-width: 3px; border-radius: 15px; margin: 1%; text-align: center">
                                Conditions
                                <p style="font-size: 9px; text-align: left; margin: 3px">${conditions}</p>
                            </div>


                        </div>

                        <%-- Main Body --%>
                        <div class="body">

                            <div class="tab">
                                <button class="tablinks" onclick="openTab(event, 'actions')">Actions</button>
                                <button class="tablinks" onclick="openTab(event, 'inventory')">Inventory</button>
                                <button class="tablinks" onclick="openTab(event, 'features')">Features & Traits</button>
                                <g:if test="${spellcaster}">
                                    <button class="tablinks" onclick="openTab(event, 'spells')">Spells</button>
                                </g:if>
                                <button class="tablinks" onclick="openTab(event, 'description')">Description</button>
                            </div>

                            <div id="actions" class="tabcontent" style="display: block">
                                <div class="actiontab">
                                    <button class="actiontablinks" onclick="openActionTab(event, 'all')">All</button>
                                    <button class="actiontablinks" onclick="openActionTab(event, 'attack')">Attack</button>
                                    <button class="actiontablinks" onclick="openActionTab(event, 'action')">Action</button>
                                    <button class="actiontablinks" onclick="openActionTab(event, 'bonusaction')">Bonus Action</button>
                                    <button class="actiontablinks" onclick="openActionTab(event, 'reaction')">Reaction</button>
                                    <button class="actiontablinks" onclick="openActionTab(event, 'other')">Other</button>
                                </div>

                                <%-- Actions --%>
                                <div class="col" style="width: 100%; border-top: solid; border-color: darkred; border-width: 2px">
                                    <div id="attack" class="actiontabcontent" style="margin-top: 5px">
                                        <h4>Attacks</h4>
                                        <hr>
                                        <table>
                                            <tr>
                                                <th>Attack</th>
                                                <th>Range</th>
                                                <th>Hit / DC</th>
                                                <th>Damage</th>
                                                <th>Type</th>
                                                <th>Notes</th>
                                                <th></th>
                                            </tr>
                                            <g:each in="${actions}">
                                                <g:if test="${it.type == "Attack"}">
                                                    <tr>
                                                        <td>${it.name}</td>
                                                        <td>${it.range}</td>
                                                        <g:if test="${it.dc == null}">
                                                            <g:hiddenField name="${it.name}" id="${it.name}" value="/r 1d20+${it.hit} & ${it.damage}"/>
                                                            <td>${it.hit}</td>
                                                            <td>${it.damage}</td>
                                                            <td>${it.dmgtype}</td>
                                                            <td>${it.notes}</td>
                                                            <td><g:render template="/roll" model="${[source: it.name, target: 'target']}"/></td>
                                                        </g:if>
                                                        <g:else>
                                                            <g:hiddenField name="${it.name}" id="${it.name}" value="/r ${it.damage}"/>
                                                            <td>${it.savetype} ${it.dc}</td>
                                                            <td>${it.damage}</td>
                                                            <td>${it.dmgtype}</td>
                                                            <td>${it.notes}</td>
                                                            <td><g:render template="/roll" model="${[source: it.name, target: 'target']}"/></td>
                                                        </g:else>
                                                    </tr>
                                                </g:if>
                                            </g:each>
                                        </table>
                                    </div> 

                                    <div id="action" class="actiontabcontent">
                                        <h4>Actions</h4>
                                        <hr>
                                        <g:each in="${actions}">
                                            <g:if test="${it.type == "Action"}">
                                                <h6 id="${it.name}name">${it.name}</h6>
                                                <p id="${it.name}body">${it.body}</h6>
                                                <g:render template="/display" model="${[sourceList: [it.name+'name', it.name+'body'], target: 'target']}"/>
                                            </g:if>
                                        </g:each>
                                    </div>

                                    <div id="bonusaction" class="actiontabcontent">
                                        <h4>Bonus Actions</h4>
                                        <hr>
                                        <g:each in="${actions}">
                                            <g:if test="${it.type == "Bonus Action"}">
                                                <h6 id="${it.name}name">${it.name}</h6>
                                                <p id="${it.name}body">${it.body}</h6>
                                                <g:render template="/display" model="${[sourceList: [it.name+'name', it.name+'body'], target: 'target']}"/>
                                            </g:if>
                                        </g:each>
                                    </div>

                                    <div id="reaction" class="actiontabcontent">
                                        <h4>Reactions</h4>
                                        <hr>
                                        <g:each in="${actions}">
                                            <g:if test="${it.type == "Reaction"}">
                                                <h6 id="${it.name}name">${it.name}</h6>
                                                <p id="${it.name}body">${it.body}</h6>
                                                <g:render template="/display" model="${[sourceList: [it.name+'name', it.name+'body'], target: 'target']}"/>
                                            </g:if>
                                        </g:each>
                                    </div>

                                    <div id="other" class="actiontabcontent">
                                        <h4>Other</h4>
                                        <hr>
                                        <g:each in="${actions}">
                                            <g:if test="${it.type == "Special"}">
                                                <h6 id="${it.name}name">${it.name}</h6>
                                                <p id="${it.name}body">${it.body}</h6>
                                                <g:render template="/display" model="${[sourceList: [it.name+'name', it.name+'body'], target: 'target']}"/>
                                            </g:if>
                                        </g:each>
                                    </div>
                                </div>
                            </div> 

                            <div id="inventory" class="tabcontent">
                                <div class="inventorytab">
                                    <button class="inventorytablinks" onclick="openInventoryTab(event, 'all')">All</button>
                                    <button class="inventorytablinks" onclick="openInventoryTab(event, 'equipped')">Equipped</button>
                                    <button class="inventorytablinks" onclick="openInventoryTab(event, 'backpack')">Backpack</button>
                                    <button class="inventorytablinks" onclick="openInventoryTab(event, 'attunement')">Attunement</button>
                                </div>

                                <%-- Inventory --%>
                                <div class="col" style="width: 100%; border-top: solid; border-color: darkred; border-width: 2px">
                                    <div id="equipped" class="inventorytabcontent" style="margin-top: 5px">
                                        <h4>Currently Equipped</h4>
                                        <hr>
                                        <table>
                                            <tr>
                                                <th>Active</th>
                                                <th>Name</th>
                                                <th>Weight</th>
                                                <th>QTY</th>
                                                <th>Cost (gp)</th>
                                                <th>Notes</th>
                                            </tr>
                                            <g:each in="${inventory}">
                                                <g:if test="${it.active}">
                                                    <g:render template="/inventoryitem" model="[item: it, hook: hook]"/>
                                                </g:if>
                                            </g:each>
                                        </table>
                                    </div>
                                    <div id="backpack" class="inventorytabcontent">
                                    <h4>Backpack</h4>
                                        <hr>
                                        <table>
                                            <tr>
                                                <th>Active</th>
                                                <th>Name</th>
                                                <th>Weight</th>
                                                <th>QTY</th>
                                                <th>Cost (gp)</th>
                                                <th>Notes</th>
                                            </tr>
                                            <g:each in="${inventory}">
                                                <g:render template="/inventoryitem" model="[item: it, hook: hook]"/>
                                            </g:each>
                                        </table>
                                    </div>
                                    <div id="attunement" class="inventorytabcontent">
                                    <h4>Attunement</h4>
                                        <hr>
                                        <div style="display: flex; flex-direction: horizontal">
                                            <div class="col">
                                                <h5>Currently Attuned</h5>
                                                <g:each in="${inventory}">
                                                    <g:if test="${it.attuned}">
                                                        <button onclick="togglePanel('${it.name}')">${it.name}</button>
                                                    </g:if>
                                                </g:each>
                                            </div>
                                            <div class="col">
                                                <h5>Items that Require Attunement</h5>
                                                <g:each in="${inventory}">
                                                    <g:if test="${it.attunable}">
                                                        <button onclick="togglePanel('${it.name}')">${it.name}</button>
                                                    </g:if>
                                                </g:each>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 

                            <div id="features" class="tabcontent">

                            </div> 

                            <div id="description" class="tabcontent">

                            </div> 

                        </div>

                    </div>

                </div>
            
            </div>

    </div>
</div>

</body>
</html>