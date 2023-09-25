<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${feat.id})">
    <td style="width: 20%; font-weight: 700">${feat.name}</td>
    <td style="width: 50%">${feat.notes}</td>
    <td style="width: 30%">${feat.tags}</td>
</tr>

<g:hiddenField name="${feat.id}target" id="${feat.id}target" value="${hook}"/>

<div id="${feat.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${feat.id})">X</button>
        <h1 name="${feat.id}name" id="${feat.id}name">${feat.name}</h1>
        <g:if test="${feat.prereq != null}">
            <h4 name="${feat.id}prereq" id="${feat.id}prereq">Prerequisite: ${feat.prereq}</h4>
            <hr/>
        </g:if>
        <p name="${feat.id}text" id="${feat.id}text" style="white-space: pre-wrap">${feat.body}</p>
        <div class="row" style="align-items: center">
            <g:if test="${feat.prereq != null}">
                <g:render template="/display" model="${[sourceList: [feat.id+'name', feat.id+'prereq', feat.id+'text'], target: feat.id+'target']}"/>
            </g:if>
            <g:else>
                <g:render template="/display" model="${[sourceList: [feat.id+'name', feat.id+'text'], target: feat.id+'target']}"/>
            </g:else>
        </div>
        <p name="${feat.id}source" id="${feat.id}source" class="sourceText">${feat.source}</p>
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