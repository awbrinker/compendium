<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>D&D Black Flag</title>
    <asset:javascript src="sendMessage.js"/>
    <asset:link rel="icon" href="BlackFlagLogo.ico" type="image/x-ico"/>
    <asset:stylesheet href="downloads.css"/>
    <asset:stylesheet href="home.css"/>
</head>
<body>
<g:render template="/navbar" />

<div role="main" class="homePage">
    <div class="mainMenu">
            
            <div class="row">
                <h1 style="font-size: 40px;">5e Tools</h1>
            </div>

            <ul class="downloadList">
                <li><g:link class="nav-link" controller="Downloads" action="download" params="${[item:'DnD 5E Character Sheet.pdf']}">DnD 5e Character Sheet</g:link></li>
                <li><g:link class="nav-link" controller="Downloads" action="download" params="${[item:'DnD 5E Character Sheet - Editable.pdf']}">DnD 5e Character Sheet - Form Fillable</g:link></li>
            </ul>
    </div>
</div>

</body>
</html>
