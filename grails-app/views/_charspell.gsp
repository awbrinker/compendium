<!DOCTYPE html>
<g:if test="${"${level}" > spell.level}">
    <tr style="align-items: center; justify-content: center; color: blue" onclick="togglePanel('${level}${spell.id}')">
</g:if>
<g:else>
    <tr style="align-items: center; justify-content: center" onclick="togglePanel('${level}${spell.id}')">
</g:else>
    <td>${spell.name}</td>
    <td>${spell.castingTimeShorthand()}</td>
    <td>${spell.range}</td>
    <td>${spell.hitDC(bonus)}</td>
    <g:if test="${spell.level == '0'}">
        <td>${spell.cantripFormula(tier)}</td>
    </g:if>
    <g:elseif test="${spell.level < "${level}"}">
        <td>${spell.charDisplayFormula(tier, bonus, level)}</td>
    </g:elseif>
    <g:elseif test="${spell.formula == 'None'}">
        <td>--</td>
    </g:elseif>
    <g:else>
        <td>${spell.formula}</td>
    </g:else>
    <td><g:each in="${spell.components}">${it}; </g:each></td>
</tr>

<g:hiddenField name="${level}${spell.id}formula" id="${level}${spell.id}formula" value="/r ${spell.charFormula(tier, bonus, level)}"/>
<g:hiddenField name="${level}${spell.id}target" id="${level}${spell.id}target" value="${hook}"/>

<div id="${level}${spell.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody" style="color: white">
        <button class="closebtn" onclick="togglePanel('${level}${spell.id}')">X</button>
        <g:if test="${spell.level != "${level}"}">
            <h1 name="${level}${spell.id}name" id="${level}${spell.id}name">${spell.name} (${level})</h1>
        </g:if>
        <g:else>
            <h1 name="${level}${spell.id}name" id="${level}${spell.id}name">${spell.name}</h1>
        </g:else>
        <g:if test="${spell.level == '0'}">
            <h3 name="${level}${spell.id}level" id="${level}${spell.id}level">${spell.school} Cantrip</h3>
        </g:if>
        <g:else>
            <h3 name="${level}${spell.id}level" id="${level}${spell.id}level">${spell.level} Level ${spell.school}</h3>
        </g:else>
        <h4 name="${level}${spell.id}casting" id="${level}${spell.id}casting">Casting time: ${spell.castingTime}</h4>
        <h4 name="${level}${spell.id}range" id="${level}${spell.id}range">Range: ${spell.range}</h4>
        <h4 name="${level}${spell.id}comps" id="${level}${spell.id}comps">Components: <g:each in="${spell.components}">${it} </g:each></h4>
        <h4 name="${level}${spell.id}duration" id="${level}${spell.id}duration">Duration: ${spell.duration}</h4>
        <p name="${level}${spell.id}text" id="${level}${spell.id}text">${spell.body}</p>
        <p name="${level}${spell.id}highText" id="${level}${spell.id}highText">${spell.highText}</p>
        <p name="${level}${spell.id}comText" id="${level}${spell.id}comText">${spell.compText}</p>
        <div class="row">
            <g:each in="${spell.classes}">
                <a href="/compendium/classes/${it}" class="classbtn">
                    <button name="${level}${spell.id}classes" id="${level}${spell.id}classes" class="classbtn">${it}</button>
                </a>
            </g:each>
        </div>
        <div class="row" style="align-items: center">
            <g:if test="${spell.formula != 'None'}">
                <g:render template="/roll" model="${[source: ("${level}"+spell.id+'formula'), target: ("${level}"+spell.id+'target')]}"/>
            </g:if>
            <g:render template="/display" model="${[sourceList: [level+spell.id+'name', level+spell.id+'level', level+spell.id+'casting', level+spell.id+'range', level+spell.id+'comps', level+spell.id+'duration', level+spell.id+'text', level+spell.id+'highText', level+spell.id+'comText'], target: level+spell.id+'target']}"/>
        </div>
        <p name="${spell.id}source" id="${spell.id}source" class="sourceText">${spell.source}</p>
    </div>
</div>

<script>
function togglePanel(id) {
    let name = id+"Collapse"
    let width = document.getElementById(name).style.width

    if(width == "350px"){
        document.getElementById(name).style.width = "0px";
    }else{
        document.getElementById(name).style.width = "350px";
    }
}
</script>