<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> 
    <asset:javascript src="sendMessage.js"/>
    <asset:javascript src="sorttable.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="home.css"/>
    <asset:stylesheet href="spell.css"/>

</head>
<body>
<g:render template="/navbar" />

<div role="main" class="homePage">
    <div class="mainMenu">
            
            <%-- Filter By Header  --%>

            <table class="sortable" style="text-align: left; width: 1400px">
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
</div>

</body>
</html>
