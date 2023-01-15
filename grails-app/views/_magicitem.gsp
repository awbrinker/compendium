<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${magicitem.id})">
    <td style="width: 28%; font-weight: 700" class="${magicitem.rarity}">${magicitem.name}</td>
    <td style="width: 12%">${magicitem.rarity}</td>
    <td style="width: 10%">${magicitem.type}</td>
    <g:if test="${magicitem.attunement}">
        <td style="width: 10%">Required</td>
    </g:if>
    <g:else>
        <td style="width: 10%">--</td>
    </g:else>
    <td style="width: 40%">${magicitem.notes}</td>
</tr>

<g:hiddenField name="${magicitem.id}target" id="${magicitem.id}target" value="${hook}"/>

<div id="${magicitem.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${magicitem.id})">X</button>
        <h1 name="${magicitem.id}name" id="${magicitem.id}name">${magicitem.name}</h1>
        <h3 name="${magicitem.id}header" id="${magicitem.id}header" style="font-style: italic">${magicitem.type}<g:if test="${magicitem.subtype !=null}"> (${magicitem.subtype})</g:if>, ${magicitem.rarity} <g:if test="${magicitem.attunement}">(requires attunement<g:if test="${magicitem.attuneNotes != null}"> by a ${magicitem.attuneNotes}</g:if>)</g:if></h3>
        <p name="${magicitem.id}text" id="${magicitem.id}text" style="white-space: pre-wrap">${magicitem.body}</p>
        <div class="row" style="align-items: center">
            <g:render template="/display" model="${[sourceList: [magicitem.id+'name', magicitem.id+'header', magicitem.id+'text'], target: magicitem.id+'target']}"/>
        </div>
        <p name="${magicitem.id}source" id="${magicitem.id}source" class="sourceText">${magicitem.source}</p>
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