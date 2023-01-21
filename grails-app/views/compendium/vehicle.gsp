<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
    <asset:javascript src="sendMessage.js"/>
    <asset:javascript src="sorttable.js"/>
    <asset:javascript src="paginator.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
    <asset:stylesheet href="spell.css"/>
    <asset:stylesheet href="table.css"/>

</head>
<body>
<g:render template="/navbar" />

<g:hiddenField name="target" id="target" value="${hook}"/>

<div role="main" class="homePage">
    <div class="mainMenu">
            <div style="align-items: left; width: 100%">
                <a href="/compendium/vehicles">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>
            
            <div style="width: 1000px; display: flex; flex-direction: horizontal">
                <div style="align-items: left; width: 50%; display: flex; flex-direction: column; margin-right: 5%">
                    <h1 name="name" id="name">${vehicle.name}</h1>
                    <h3 name="header" id="header" style="font-style: italic">${vehicle.size} Vehicle<g:if test="${vehicle.sizetext !=null}"> (${vehicle.sizetext})</g:if></h3>
                    <hr/>
                    <div name="crew" id="crew">Creature Capacity: ${vehicle.crew}</div>
                    <div name="cargo" id="cargo">Cargo Capacity: ${vehicle.cargo}</div>
                    <div name="init" id="init">Roll Initiative! (${(int)((vehicle.stats[1]-10)/2)})</div>
                    <g:hiddenField name="initRoll" id="initRoll" value="/r d20+${(int)((vehicle.stats[1]-10)/2)}"/>
                    <div class="row">
                        <g:render template="/roll" model="${[source: ('initRoll'), target: ('target')]}"/>
                    </div>
                    <div name="stats" id="stats">
                    <g:each in="${(0..<6)}">
                        <g:hiddenField name="stats${it}" id="stats${it}" value="/r d20+${(int)((vehicle.stats[it]-10)/2)}"/>
                        <button style="width: 60px; padding: 0px" onclick="sendMessageTo('stats'+${it}, 'target')">
                            <div>${["STR", "DEX", "CON", "INT", "WIS", "CHA"][it]}</div>
                            <div>${vehicle.stats[it]} <g:if test="${vehicle.stats[it] != 0}">(${(int)((vehicle.stats[it]-10)/2)})</g:if></div>
                        </button>
                    </g:each>
                    </div>
                    <p></p>
                    <div name="immunities" id="immunities">Damage Immunities: Poison, Psychic</div>
                    <div name="condImmunities" id="condImmunities">Condition Immunities: Blinded, Charmed, Deafened, Exhaustion, Frightened, Incapacitated, Paralyzed, Petrified, Poisoned, Prone, Stunned, Unconscious</div>
                    <div class="row" style="align-items: center">
                        <g:render template="/display" model="${[sourceList: ['name', 'header', 'crew', 'cargo', 'stats', 'immunities', 'condImmunities', ], target: 'target']}"/>
                    </div>
                    <hr/>

                    <div name="actions" id="actions">
                        <h3>Actions</h3>
                        <hr/>
                        <g:each in="${(0..<vehicle.actions.length)}">
                            <p style="white-space: pre-wrap" id="act${it}">${vehicle.actions[it]}</p>
                            <g:hiddenField name="actform${it}" id="actform${it}" value="/r ${vehicle.actionFormulas[it]}"/>
                            <div class="row">
                                <g:if test="${vehicle.actionFormulas[it] != "None"}">
                                        <g:render template="/roll" model="${[source: ('actform'+it), target: ('target')]}"/>
                                </g:if>
                            </div>
                        </g:each>
                        <div class="row">
                            <g:render template="/display" model="${[sourceList: ['name', 'actions'], target: 'target']}"/>
                        </div>
                    </div>

                    <div name="components" id="components">
                        <g:each in="${(0..<(int)(vehicle.components.length/3))}" var="comp">
                            <div name="component${comp}" id="component${comp}">
                                <h3>${vehicle.components[comp][0]}</h3>
                                <hr/>
                                <g:each in="${(1..<vehicle.components[comp].length)}">
                                    <p style="white-space: pre-wrap" id="comp${comp}">${vehicle.components[comp][it]}</p>
                                    <g:hiddenField name="compform${comp}${it}" id="compform${comp}${it}" value="/r ${vehicle.compFormulas[comp][it]}"/>
                                    <div class="row">
                                        <g:if test="${vehicle.compFormulas[comp][it] != "None"}">
                                                <g:render template="/roll" model="${[source: ('compform'+comp+it), target: ('target')]}"/>
                                        </g:if>
                                    </div>
                                </g:each>
                            </div>
                            <div class="row">
                                <g:render template="/display" model="${[sourceList: ['name', 'component'+comp], target: 'target']}"/>
                            </div>
                        </g:each>
                    </div>
                </div>

                <div style="width: 50%; display: flex; flex-direction: column; margin-left: 5%">
                    <div name="components2" id="components2">
                        <g:each in="${((int)(vehicle.components.length/3)..<vehicle.components.length)}" var="comp">
                            <div name="component${comp}" id="component${comp}">
                                <h3>${vehicle.components[comp][0]}</h3>
                                <hr/>
                                <g:each in="${(1..<vehicle.components[comp].length)}">
                                    <p style="white-space: pre-wrap" id="comp${comp}">${vehicle.components[comp][it]}</p>
                                    <g:hiddenField name="compform${comp}${it}" id="compform${comp}${it}" value="/r ${vehicle.compFormulas[comp][it]}"/>
                                    <div class="row" style="width: 50%">
                                        <g:if test="${vehicle.compFormulas[comp][it] != "None"}">
                                                <g:render template="/roll" model="${[source: ('compform'+comp+it), target: ('target')]}"/>
                                        </g:if>
                                    </div>
                                </g:each>
                                <div class="row" style="width: 50%">
                                    <g:render template="/display" model="${[sourceList: ['name', 'component'+comp], target: 'target']}"/>
                                </div>
                            </div>
                        </g:each>
                    </div>
                </div>
            </div>

    </div>
</div>

</body>
</html>