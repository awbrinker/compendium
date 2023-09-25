<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel('${item.name}')">
    <g:if test="${item.active}"><td>&#9635;</td></g:if>
    <g:else><td>&#9634;</td></g:else>
    <td>${item.name}</td>
    <td>${item.weight}</td>
    <td>${item.qty}</td>
    <td>${item.cost}</td>
    <td>${item.notes}</td>
</tr>

<g:hiddenField name="target" id="target" value="${hook}"/>

<div id="${item.name}Collapse" class="sidepanel" style="color: white">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel('${item.name}')">X</button>
        <h1 name="${item.name}name" id="${item.name}name">${item.name}</h1>
        <h4 name="${item.name}cost" id="${item.name}cost">Cost: ${item.cost}</h4>
        <h4 name="${item.name}weight" id="${item.name}weight">Weight: ${item.weight}</h4>
        <h4 name="${item.name}qty" id="${item.name}qty">Carried: ${item.qty}</h4>
        <p name="${item.name}notes" id="${item.name}notes">Notes: ${item.notes}</p>
        <g:if test="${item.attunable}">
            <g:if test="${item.attuned}"><p>Currently Attuned</p></g:if>
            <g:else><p>Requires Attunement</p></g:else>
        </g:if>
        <p name="${item.name}text" id="${item.name}text">${item.body}</p>
        <div class="row" style="align-items: center">
                <g:render template="/display" model="${[sourceList: [item.name+'name', item.name+'cost', item.name+'weight', item.name+'qty', item.name+'notes', item.name+'text'], target: 'target']}"/>
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