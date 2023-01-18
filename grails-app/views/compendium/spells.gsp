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

<div role="main" class="homePage">
    <div class="mainMenu">
            
            <button class="filterbtnlg" type="button" data-toggle="collapse" data-target="#aboutCollapse" aria-expanded="false" aria-controls="aboutCollapse">
                Filter Spells
            </button>
            <div class="collapse" id="aboutCollapse" style="align-items: center">
                <div class="card card-body" style="background-color: rgb(47, 47, 47, 0.8); border: none; align-items: center">
                    <g:form controller="compendium" action="filterSpells">
                    <table class="plain">
                        <thead>
                            <th><b>Spell Name</b></th>
                            <th><b>Spell Level</b></th>
                            <th><b>Tags</b></th>
                            <th><b>Casting Time</b></th>
                            <th><b></b></th>
                        </thead>
                        <tr>
                            <td><g:textField name="nameFilter" value="${nameFilter}"/></td>
                            <td>
                                <g:select name="levelStart" from="${['--', '0th', '1st', '2nd', '3rd', '4th', '5th', '6th', '7th', '8th', '9th']}" value="${levelStart}"/>
                                to
                                <g:select name="levelEnd" from="${['--', '0th', '1st', '2nd', '3rd', '4th', '5th', '6th', '7th', '8th', '9th']}" value="${levelEnd}"/>
                            </td>
                            <td><g:select name="tagFilter" from="${["--", "Banishment", "Buff", "Charmed", "Combat", "Communication", "Compulsion", "Control", "Creation", "Damage", "Debuff", "Deception", "Detection",
                                                                    "Dunamancy", "Environment", "Exploration", "Foreknowledge", "Healing", "Movement", "Negation", "Psionic", "Scrying", "Shapechanging", "Social", "Special",
                                                                    "Summoning", "Teleportation", "Utility", "Warding"]}" value="${tagFilter}"/></td>                            
                            <td><g:select name="castingTimeFilter" from="${["--", "1 Action", "1 Bonus Action", "1 Reaction", "1 Minute", "10 Minutes", "1 Hour", "8 Hours", "12 Hours", "24 Hours"]}" value="${castingTimeFilter}"/></td>
                            <td><g:submitButton name="filterButton" value="Filter Spells" class="filterbtn"/></td>
                        </tr>
                    </table>
                    <div class="row">
                        <g:actionSubmit name="resetButton" value="Reset Filters" class="filterbtn" action="spells"/>
                    </div>
                </div>
            </div>

            <hr/>

            <p>Currently loaded ${start} to ${end} of ${count} total items.</p>
            <div style="display: flex; flex-direction: horizontal; padding: 5px">
            <g:field type="number" name="start" value="${start}"/>
            <g:field type="number" name="end" value="${end}"/>
            <g:submitButton name="reload" value="Reload"/>
            </div>

            </g:form>

            <div id="table_box_bootstrap">
                <table class="sortable" id="data" name="data" style="text-align: left; width: 1400px">
                    <thead>
                    <th><b>Level</b></th>
                    <th><b>Name</b></th>
                    <th><b>Casting Time</b></th>
                    <th><b>Duration</b></th>
                    <th><b>Range</b></th>
                    <th><b>Attack</b></th>
                    <th><b>Save</b></th>
                    <th><b>Damage/Effect</b></th>
                    </thead>

                    <g:each in="${spells}">
                        <g:render template="/spell" model="[spell: it, hook: hook]" />
                    </g:each>
                </table>
            </div>
            <div id="index_native" class="box"></div>

            <script type="text/javascript">
                window.addEventListener("load", function () {
                    var box = paginator({
                        table: document.getElementById("table_box_bootstrap").getElementsByTagName("table")[0],
                        box_mode: "list",
                    });
                    box.className = "box";
                    document.getElementById("table_box_bootstrap").appendChild(box);
                }, false);
            </script>

    </div>
</div>

</body>
</html>