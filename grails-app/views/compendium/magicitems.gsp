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
            <div style="align-items: left; width: 100%">
                <a href="/compendium">
                    <button class="backbtn">
                        <p>Back</p>
                    </button>
                </a>
            </div>
            
            <button class="filterbtnlg" type="button" data-toggle="collapse" data-target="#aboutCollapse" aria-expanded="false" aria-controls="aboutCollapse">
                Filter Magic Items
            </button>
            <div class="collapse" id="aboutCollapse" style="align-items: center">
                <div class="card card-body" style="background-color: rgb(47, 47, 47, 0.8); border: none; align-items: center">
                    <g:form controller="compendium" action="filterMagicItems">
                    <table class="plain">
                        <thead>
                            <th><b>Name</b></th>
                            <th><b>Rarity</b></th>
                            <th><b>Requires Attunement</b></th>
                            <th><b>Type</b></th>
                            <th><b>Tags</b></th>
                            <th><b></b></th>
                        </thead>
                        <tr>
                            <td><g:textField name="nameFilter" value="${nameFilter}"/></td>
                            <td><g:select name="rarityFilter" from="${['--', 'Common', 'Uncommon', 'Rare', 'Very Rare', 'Legendary', 'Artifact']}" value="${rarityFilter}"/></td>
                            <td><g:select name="attuneFilter" from="${['--', 'Yes', 'No']}" value="${attuneFilter}"/></td>
                            <td><g:select name="typeFilter" from="${['--', 'Armor', 'Potion', 'Ring', 'Rod', 'Scroll', 'Staff', 'Wand', 'Weapon', 'Wondrous Item']}" value="${typeFilter}"/></td>
                            <td><g:select name="tagFilter" from="${["--", "Bane", "Banishment", "Belt", "Buff", "Charmed", "Combat", "Communication", "Compulsion", "Consumable", "Container", "Control", "Creation", "Cursed", "Damage", "Debuff", "Deception", "Detection",
                                                                    "Dunamancy", "Environment", "Exploration", "Eyewear", "Focus", "Foreknowledge", "Footwear", "Handwear", "Headwear", "Healing", "Instrument", "Jewelry", "Movement", "Necklace", "Negation", 
                                                                    "Outerwear", "Psionic", "Sentient", "Scrying", "Shapechanging", "Social", "Summoning", "Teleportation", "Utility", "Warding", "Wristwear"]}" value="${tagFilter}"/></td>                            
                            <td><g:submitButton name="filterButton" value="Filter Magic Items" class="filterbtn"/></td>
                        </tr>
                    </table>
                    <div class="row">
                        <g:actionSubmit name="resetButton" value="Reset Filters" class="filterbtn" action="magicitems"/>
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
                    <th><b>Name</b></th>
                    <th><b>Rarity</b></th>
                    <th><b>Type</b></th>
                    <th><b>Attunement</b></th>
                    <th><b>Notes</b></th>
                    </thead>

                    <g:each in="${magicitems}">
                        <g:render template="/magicitem" model="[magicitem: it, hook: hook]" />
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