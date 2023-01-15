<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${item.id})">
    <td style="width: 20%; font-weight: 700">${item.name}</td>
    <td style="width: 20%">${item.type}</td>
    <td style="width: 7%">${item.cost}</td>
    <td style="width: 7%">${item.weight}</td>
    <td style="width: 10%">${item.attributes}</td>
    <td style="width: 10%">${item.notes}</td>
</tr>

<g:hiddenField name="${item.id}target" id="${item.id}target" value="${hook}"/>

<div id="${item.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${item.id})">X</button>
        <h1 name="${item.id}name" id="${item.id}name">${item.name}</h1>
        <h3 name="${item.id}type" id="${item.id}type">${item.type}</h3>
        <h4 name="${item.id}cost" id="${item.id}cost">Cost: ${item.cost}</h4>
        <h4 name="${item.id}weight" id="${item.id}weight">Weight: ${item.weight}</h4>
        <p name="${item.id}attributes" id="${item.id}attributes">Attributes: ${item.attributes}</p>
        <p name="${item.id}notes" id="${item.id}notes">Notes: ${item.notes}</p>
        <g:if test="${item.damage != null}">
            <p name="${item.id}damage" id="${item.id}damage">Damage: ${item.damage}</p>
        </g:if>
        <p name="${item.id}text" id="${item.id}text">${item.body}</p>
        <div class="row" style="align-items: center">
            <g:if test="${item.damage != null}">
                <g:render template="/display" model="${[sourceList: [item.id+'name', item.id+'type', item.id+'cost', item.id+'weight', item.id+'attributes', item.id+'notes', item.id+'damage', item.id+'text'], target: item.id+'target']}"/>
            </g:if>
            <g:else>
                <g:render template="/display" model="${[sourceList: [item.id+'name', item.id+'type', item.id+'cost', item.id+'weight', item.id+'attributes', item.id+'notes', item.id+'text'], target: item.id+'target']}"/>
            </g:else>
        </div>
        <p name="${item.id}source" id="${item.id}source" class="sourceText">${item.source}</p>
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