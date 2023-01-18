<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${monster.id})">
    <td style="width: 10%">${monster.cr}</td>
    <td style="width: 15%; font-weight: 700">${monster.name}</td>
    <td style="width: 10%">${monster.type}</td>
    <td style="width: 10%">${monster.subtype}</td>
    <td style="width: 8%">${monster.size}</td>
    <td style="width: 10%">${monster.alignment}</td>
    <td style="width: 15%">${monster.environment}</td>
    <td style="width: 13%">${monster.tags}</td>
</tr>

<g:hiddenField name="${monster.id}target" id="${monster.id}target" value="${hook}"/>

<div id="${monster.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${monster.id})">X</button>
        <h1 name="${monster.id}name" id="${monster.id}name">${monster.name}</h1>
        <div name="${monster.id}header" id="${monster.id}header" style="font-style: italic">${monster.size} ${monster.type}<g:if test="${monster.subtype !=null}"> (${monster.subtype})</g:if>, ${monster.alignment}</div>
        <hr/>
        <div name="${monster.id}ac" id="${monster.id}ac">Armor Class: ${monster.ac}<g:if test="${monster.actext != null}"> (${monster.actext})</g:if></div>
        <div name="${monster.id}hp" id="${monster.id}hp">Hit Points: ${monster.hp} (${monster.hpformula})</div>
        <div name="${monster.id}speed" id="${monster.id}speed">Speed: ${monster.speed}</div>
        <hr/>
        <div name="${monster.id}stats" id="${monster.id}stats">
            <g:each in="${(0..<6)}">
                <g:hiddenField name="${monster.id}stats${it}" id="${monster.id}stats${it}" value="/r d20+${(int)((monster.stats[it]-10)/2)}"/>
                <button style="width: 60px; padding: 0px" onclick="sendMessageTo(${monster.id}+'stats'+${it}, ${monster.id}+'target')">
                    <div>${["STR", "DEX", "CON", "INT", "WIS", "CHA"][it]}</div>
                    <div>${monster.stats[it]} (${(int)((monster.stats[it]-10)/2)})</div>
                </button>
            </g:each>
        </div>
        <hr/>
        <div name="${monster.id}saves" id="${monster.id}saves">
            <g:if test="${monster.saves.sum() != 0}">Saving Throws: 
                <g:each in="${0..<6}">
                    <g:if test="${monster.saves[it] != 0}">
                        <g:hiddenField name="${monster.id}saves${it}" id="${monster.id}saves${it}" value="/r d20+${(int)((monster.stats[it]-10)/2)+(monster.prof)}"/>
                        <button onclick="sendMessageTo(${monster.id}+'saves'+${it}, ${monster.id}+'target')">${["STR", "DEX", "CON", "INT", "WIS", "CHA"][it]} +${(int)((monster.stats[it]-10)/2)+(monster.prof)}</button>
                    </g:if>
                </g:each>
            </g:if>
        </div>
        <div name="${monster.id}skills" id="${monster.id}skills">
            <g:if test="${monster.skills != null}">Skills: 
                <g:each in="${0..<monster.skills.length}">
                    <g:hiddenField name="${monster.id}skills${it}" id="${monster.id}skills${it}" value="/r d20+${monster.skillBonus[it]}"/>
                    <button onclick="sendMessageTo(${monster.id}+'skills'+${it}, ${monster.id}+'target')">${monster.skills[it]} +${monster.skillBonus[it]}</button>
                </g:each>
            </g:if>
        </div>

        <div name="${monster.id}resistances" id="${monster.id}resistances">
            <g:if test="${monster.resistances != null}">Damage Resistances: 
                <g:each in="${0..<monster.resistances.length}">
                    ${monster.resistances[it]}<g:if test="${it != monster.resistances.length-1}">, </g:if>
                </g:each>
            </g:if>
        </div>
        <div name="${monster.id}immunities" id="${monster.id}immunities">
            <g:if test="${monster.immunities != null}">Damage Immunities: 
                <g:each in="${0..<monster.immunities.length}">
                    ${monster.immunities[it]}<g:if test="${it != monster.immunities.length-1}">, </g:if>
                </g:each>
            </g:if>
        </div>
        <div name="${monster.id}vulnerabilities" id="${monster.id}vulnerabilities">
            <g:if test="${monster.vulnerabilities != null}">Damage Vulnerabilities: 
                <g:each in="${0..<monster.vulnerabilities.length}">
                    ${monster.vulnerabilities[it]}<g:if test="${it != monster.vulnerabilities.length-1}">, </g:if>
                </g:each>
            </g:if>
        </div>
        <div name="${monster.id}conditionImmunities" id="${monster.id}conditionImmunities">
            <g:if test="${monster.conditionImmunities != null}">Condition Immunities: 
                <g:each in="${0..<monster.conditionImmunities.length}">
                    ${monster.conditionImmunities[it]}<g:if test="${it != monster.conditionImmunities.length-1}">, </g:if>
                </g:each>
            </g:if>
        </div>

        <div name="${monster.id}senses" id="${monster.id}senses">Senses: ${monster.senses}</div>
        <div name="${monster.id}languages" id="${monster.id}languages">Languages: ${monster.languages}</div>
        <div name="${monster.id}cr" id="${monster.id}cr" style="white-space: pre-wrap">Challenge ${monster.cr}      Proficiency Bonus +${monster.prof}</div>

        <div class="row" style="align-items: center">
            <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'header', monster.id+'ac', monster.id+'hp', monster.id+'speed', monster.id+'stats', monster.id+'saves', 
                                                                monster.id+'skills', monster.id+'resistances', monster.id+'immunities', monster.id+'vulnerabilities', monster.id+'conditionImmunities', 
                                                                monster.id+'senses', monster.id+'languages', monster.id+'cr'], target: monster.id+'target']}"/>
        </div>

        <g:if test="${monster.attributes != null}">
            <hr/>
            <div name="${monster.id}attributes" id="${monster.id}attributes">
                <g:each in="${(0..<monster.attributes.length)}">
                    <p style="white-space: pre-wrap" id="${monster.id}at${it}">${monster.attributes[it]}</p>
                    <g:hiddenField name="${monster.id}atform${it}" id="${monster.id}atform${it}" value="/r ${monster.attributeFormulas[it]}"/>
                    <div class="row">
                        <g:if test="${monster.attributeFormulas[it] != "None"}">
                                <g:render template="/roll" model="${[source: (monster.id+'atform'+it), target: (monster.id+'target')]}"/>
                        </g:if>
                        <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'at'+it], target: monster.id+'target']}"/>
                    </div>
                </g:each>
            </div>
        </g:if>
        <h2>Actions</h2>
        <hr/>
        <div name="${monster.id}actions" id="${monster.id}actions">
            <g:each in="${(0..<monster.actions.length)}">
                <p style="white-space: pre-wrap" id="${monster.id}act${it}">${monster.actions[it]}</p>
                <g:hiddenField name="${monster.id}actform${it}" id="${monster.id}actform${it}" value="/r ${monster.actionFormulas[it]}"/>
                <div class="row">
                    <g:if test="${monster.actionFormulas[it] != "None"}">
                            <g:render template="/roll" model="${[source: (monster.id+'actform'+it), target: (monster.id+'target')]}"/>
                    </g:if>
                    <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'act'+it], target: monster.id+'target']}"/>
                </div>
            </g:each>
        </div>
        <g:if test="${monster.bonusActions != null}">
            <h2>Legendary Actions</h2>
            <hr/>
            <div name="${monster.id}bonusActions" id="${monster.id}bonusActions">
                <g:each in="${(0..<monster.bonusActions.length)}">
                    <p style="white-space: pre-wrap" id="${monster.id}bact${it}">${monster.bonusActions[it]}</p>
                    <g:hiddenField name="${monster.id}lactform${it}" id="${monster.id}bactform${it}" value="/r ${monster.bonusActionFormulas[it]}"/>
                    <div class="row">
                    <g:if test="${monster.bonusActionFormulas[it] != "None"}">
                            <g:render template="/roll" model="${[source: (monster.id+'bactform'+it), target: (monster.id+'target')]}"/>
                    </g:if>
                    <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'bact'+it], target: monster.id+'target']}"/>
                </div>
                </g:each>
            </div>
        </g:if>
        <g:if test="${monster.reactions != null}">
            <h2>Legendary Actions</h2>
            <hr/>
            <div name="${monster.id}reactions" id="${monster.id}reactions">
                <g:each in="${(0..<monster.reactions.length)}">
                    <p style="white-space: pre-wrap" id="${monster.id}react${it}">${monster.reactions[it]}</p>
                    <g:hiddenField name="${monster.id}lactform${it}" id="${monster.id}reactform${it}" value="/r ${monster.reactionFormulas[it]}"/>
                    <div class="row">
                    <g:if test="${monster.reactionFormulas[it] != "None"}">
                            <g:render template="/roll" model="${[source: (monster.id+'reactform'+it), target: (monster.id+'target')]}"/>
                    </g:if>
                    <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'react'+it], target: monster.id+'target']}"/>
                </div>
                </g:each>
            </div>
        </g:if>
        <g:if test="${monster.legendaryActions != null}">
            <h2>Legendary Actions</h2>
            <hr/>
            <div name="${monster.id}legendaryActions" id="${monster.id}legendaryActions">
                <g:each in="${(0..<monster.legendaryActions.length)}">
                    <p style="white-space: pre-wrap" id="${monster.id}lact${it}">${monster.legendaryActions[it]}</p>
                    <g:hiddenField name="${monster.id}lactform${it}" id="${monster.id}lactform${it}" value="/r ${monster.legendaryActionFormulas[it]}"/>
                    <div class="row">
                    <g:if test="${monster.legendaryActionFormulas[it] != "None"}">
                            <g:render template="/roll" model="${[source: (monster.id+'lactform'+it), target: (monster.id+'target')]}"/>
                    </g:if>
                    <g:render template="/display" model="${[sourceList: [monster.id+'name', monster.id+'lact'+it], target: monster.id+'target']}"/>
                </div>
                </g:each>
            </div>
        </g:if>
        <hr/>

    </div>
</div>

<script>
function togglePanel(id) {
    let name = id+"Collapse"
    let width = document.getElementById(name).style.width

    if(width == "450px"){
        document.getElementById(name).style.width = "0px";
    }else{
        document.getElementById(name).style.width = "450px";
    }
}
</script>