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
                Filter Monsters
            </button>
            <div class="collapse" id="aboutCollapse" style="align-items: center">
                <div class="card card-body" style="background-color: rgb(47, 47, 47, 0.8); border: none; align-items: center">
                    <g:form controller="compendium" action="filterMonsters">
                    <table class="plain">
                        <thead>
                            <th><b>Monster Name</b></th>
                            <th><b>Challenge Range</b></th>
                            <th><b>Size</b></th>
                            <th><b>Environment</b></th>
                            <th><b>Type/Subtype</b></th>
                            <th><b></b></th>
                        </thead>
                        <tr>
                            <td><g:textField name="nameFilter" value="${nameFilter}"/></td>
                            <td >
                                <g:select name="crStart" from="${['--', '1/8', '1/4', '1/2', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30']}" value="${crStart}"/>
                                to
                                <g:select name="crEnd" from="${['--', '1/8', '1/4', '1/2', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30']}" value="${crEnd}"/>
                            </td>
                            <td><g:select name="sizeFilter" from="${["--", "Tiny", "Small", "Medium", "Large", "Huge", "Gargantuan"]}" value="${sizeFilter}"/></td>
                            <td><g:select name="environmentFilter" from="${["--", "Arctic", "Coastal", "Desert", "Forest", "Grassland", "Hill", "Mountain", "Swamp", "Underdark", "Underwater", "Urban"]}" value="${environmentFilter}"/></td>
                            <td><g:textField name="typeFilter" value="${typeFilter}"/></td>
                            <td><g:submitButton name="filterButton" value="Filter Monsters" class="filterbtn"/></td>
                        </tr>
                    </table>
                    <div class="row">
                        <g:actionSubmit name="resetButton" value="Reset Filters" class="filterbtn" action="monsters"/>
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

            <div id="index_native" class="box"></div>
            <div id="table_box_bootstrap">
                <table id="data" name="data" style="text-align: left; width: 1400px">
                    <thead>
                        <th><b>
                            <div class="row">
                                CR
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersCrAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersCrDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Name
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersNameAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersNameDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Type
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersTypeAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersTypeDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Subtype
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersSubtypeAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersSubtypeDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Size
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersSizeAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersSizeDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Alignment
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersAlignmentAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersAlignmentDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Environment
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersEnvironmentAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersEnvironmentDesc"/>
                                </div>
                            </div>
                        </b></th>
                        <th><b>
                            <div class="row">
                                Tags
                                <div class="col">
                                <g:actionSubmit class="sortbtn" value="&#9650;" action="sortMonstersTagsAsc"/>
                                <g:actionSubmit class="sortbtn" value="&#9660;" action="sortMonstersTagsDesc"/>
                                </div>
                            </div>
                        </b></th>
                    </g:form>
                    </thead>

                    <g:each in="${monsters}">
                        <g:render template="/monster" model="[monster: it, hook: hook]" />
                    </g:each>
                </table>
            </div>

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