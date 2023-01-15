<!DOCTYPE html>

<tr style="align-items: center; justify-content: center" onclick="togglePanel(${background.id})">
    <td style="width: 25%; font-weight: 700">${background.name}</td>
    <td style="width: 25%">${background.featureName}</td>
    <td style="width: 25%">${background.skills}</td>
    <td style="width: 25%">${background.tags}</td>
</tr>

<g:hiddenField name="${background.id}target" id="${background.id}target" value="${hook}"/>

<div id="${background.id}Collapse" class="sidepanel">
    <div class="card card-body spellBody">
        <button class="closebtn" onclick="togglePanel(${background.id})">X</button>
        <h1 name="${background.id}name" id="${background.id}name">${background.name}</h1>
        <p name="${background.id}text" id="${background.id}text" style="white-space: pre-wrap">${background.body}</p>
        <hr/>
        <p name="${background.id}skills" id="${background.id}skills">Skill Proficiencies: ${background.skills}</p>
        <p name="${background.id}languages" id="${background.id}languages">Languages: ${background.languages}</p>
        <g:if test="${background.tools != null}">
            <p name="${background.id}tools" id="${background.id}tools">Tool Proficiencies: ${background.tools}</p>
        </g:if>
        <p name="${background.id}equipment" id="${background.id}equipment">Equipment: ${background.equipment}</p>
        <hr/>
        <h4 name="${background.id}featurename" id="${background.id}featurename">Feature: ${background.featureName}</h4>
        <p name="${background.id}featuretext" id="${background.id}featuretext" style="white-space: pre-wrap">${background.featureText}</p>
        <h4 name="${background.id}charheader" id="${background.id}charheader">Suggested Characteristics:</h4>
        <p name="${background.id}characteristics" id="${background.id}characteristics" style="white-space: pre-wrap">${background.characteristics}</p>
        <div class="row" style="align-items: center">
            <g:if test="${background.tools != null}">
                <g:render template="/display" model="${[sourceList: [background.id+'name', background.id+'text', background.id+'skills', background.id+'languages', background.id+'tools', background.id+'equipment', background.id+'featurename', background.id+'featuretext', background.id+'charheader', background.id+'characteristics'], target: background.id+'target']}"/>
            </g:if>
            <g:else>
                <g:render template="/display" model="${[sourceList: [background.id+'name', background.id+'text', background.id+'skills', background.id+'languages', background.id+'equipment', background.id+'featurename', background.id+'featuretext', background.id+'charheader', background.id+'characteristics'], target: background.id+'target']}"/>
            </g:else>
        </div>
        <p name="${background.id}source" id="${background.id}source" class="sourceText">${background.source}</p>
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