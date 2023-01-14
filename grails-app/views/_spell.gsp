<!DOCTYPE html>

<g:hiddenField name="${spell.id}formula" id="${spell.id}formula" value="/r ${spell.formula}"/>
<g:hiddenField name="${spell.id}target" id="${spell.id}target" value="${hook}"/>

<tr style="align-items: center" onclick="togglePanel(${spell.id})">
    <td style="width: 10%">${spell.level}</td>
    <td style="width: 15%">${spell.name}</td>
    <td style="width: 15%">${spell.castingTime}</td>
    <td style="width: 15%">${spell.duration}</td>
    <td style="width: 10%">${spell.range}</td>
    <td style="width: 10%">${spell.atk}</td>
    <td style="width: 10%">${spell.save}</td>
    <td style="width: 15%">
    <g:each in="${spell.dmgType}">${it}; </g:each>
    </td>
</tr>

<div id="${spell.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${spell.id})">X</button>
        <h1>${spell.name}</h1>
        <h3>${spell.level} Level ${spell.school}</h3>
        <p name="${spell.id}text" id="${spell.id}text">${spell.body}</p>
        <p name="${spell.id}text2" id="${spell.id}text2">${spell.highText}</p>
        <p name="${spell.id}text3" id="${spell.id}text3">${spell.compText}</p>
        <div class="row" style="align-items: center">
            <g:render template="/roll" model="[source: 'formula', target: 'target']"/>
            <g:render template="/display" model="[sourceList: ['${spell.id}text', '${spell.id}text2', '${spell.id}text3'], target: '${spell.id}target']"/>
        </div>
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
