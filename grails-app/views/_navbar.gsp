<!DOCTYPE html>

<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Content<span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Characters</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Compendium <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="#">Races</a></li>
            <li class="dropdown-item"><a href="#">Classes</a></li>
            <li class="dropdown-item"><a href="#">Backgrounds</li>
            <li class="dropdown-item"><a href="#">Feats</li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Equipment </li>
            <li class="dropdown-item"><a href="#">Vehicles</a></li>
            <li class="dropdown-item"><a href="#">Magic Items</a></li>
            <li role="separator" class="dropdown-divider"></li>
            <li class="dropdown-item"><a href="#">Spells</a></li>
            <li class="dropdown-item"><a href="#">Monsters</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Downloads <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li class="dropdown-item"><a href="/downloads/sources">Sources </a></li>
            <li class="dropdown-item"><a href="/downloads/tools">Tools </a></li>
        </ul>
    </li>
    <sec:ifLoggedIn>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><sec:username/><span class="caret"></span></a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="dropdown-item"><a href="/user/index">View Profile</a></li>
                    <li class="dropdown-item"><g:link class="nav-link" controller="Logout">Log out</g:link></li>
                </ul>
            </li>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Profile <span class="caret"></span></a>
            <ul class="dropdown-menu dropdown-menu-right">
                <li class="dropdown-item"><a href="/login/auth">Log in </a></li>
            </ul>
        </li>
    </sec:ifNotLoggedIn>
</content>