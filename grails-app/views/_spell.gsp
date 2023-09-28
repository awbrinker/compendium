<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${spell.id})">
    <g:if test="${spell.level == '0'}">
        <td style="width: 10%">Cantrip</td>
    </g:if>
    <g:else>
        <td style="width: 10%">${spell.level}</td>
    </g:else>
    <td style="width: 15%; font-weight: 700">${spell.name}</td>
    <td style="width: 15%">${spell.castingTime}</td>
    <td style="width: 15%">${spell.duration}</td>
    <td style="width: 10%">${spell.range}</td>
    <td style="width: 10%">${spell.atk}</td>
    <td style="width: 10%">${spell.save}</td>
    <td style="width: 15%">
    <g:each in="${spell.dmgType}">${it}; </g:each>
    </td>
</tr>

<g:hiddenField name="${spell.id}formula" id="${spell.id}formula" value="/r ${spell.formula}"/>
<g:hiddenField name="${spell.id}target" id="${spell.id}target" value="${hook}"/>

<div id="${spell.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${spell.id})">X</button>
        <h1 name="${spell.id}name" id="${spell.id}name">${spell.name}</h1>
        <g:if test="${spell.level == '0'}">
            <h3 name="${spell.id}level" id="${spell.id}level">${spell.school} Cantrip</h3>
        </g:if>
        <g:else>
            <h3 name="${spell.id}level" id="${spell.id}level">${spell.level} Level ${spell.school}</h3>
        </g:else>
        <h4 name="${spell.id}casting" id="${spell.id}casting">Casting time: ${spell.castingTime}</h4>
        <h4 name="${spell.id}range" id="${spell.id}range">Range: ${spell.range}</h4>
        <h4 name="${spell.id}comps" id="${spell.id}comps">Components: <g:each in="${spell.components}">${it} </g:each></h4>
        <h4 name="${spell.id}duration" id="${spell.id}duration">Duration: ${spell.duration}</h4>
        <p name="${spell.id}text" id="${spell.id}text">${spell.body}</p>
        <p name="${spell.id}highText" id="${spell.id}highText">${spell.highText}</p>
        <p name="${spell.id}comText" id="${spell.id}comText">${spell.compText}</p>
        <div class="row">
            <g:each in="${spell.classes}">
                <a href="/compendium/classes/${it}" class="classbtn">
                    <button name="${spell.id}classes" id="${spell.id}classes" class="classbtn">${it}</button>
                </a>
            </g:each>
        </div>
        <div class="row" style="align-items: center">
            <g:if test="${spell.formula != 'None'}">
                <g:render template="/roll" model="${[source: (spell.id+'formula'), target: (spell.id+'target')]}"/>
            </g:if>
            <g:render template="/display" model="${[sourceList: [spell.id+'name', spell.id+'level', spell.id+'casting', spell.id+'range', spell.id+'comps', spell.id+'duration', spell.id+'text', spell.id+'highText', spell.id+'comText'], target: spell.id+'target']}"/>
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