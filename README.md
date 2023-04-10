<div align=center id=pocketcats>

# PocketCats :cat2:

</div>

<div align=center>
    <a href="https://img.shields.io/github/last-commit/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/last-commit/Pauwul/PocketCats" alt="GitHub last commit">
    </a>
    <a href="https://img.shields.io/github/repo-size/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/repo-size/Pauwul/PocketCats" alt="GitHub repo size">
    </a>
    <a href="https://img.shields.io/github/license/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/license/Pauwul/PocketCats" alt="GitHub">
    </a>
    <a href="https://img.shields.io/github/issues/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/issues/Pauwul/PocketCats" alt="GitHub issues">
    </a>
    <a href="https://img.shields.io/github/issues-pr/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/issues-pr/Pauwul/PocketCats" alt="GitHub pull requests">
    </a>
    <a href="https://img.shields.io/github/contributors/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/contributors/Pauwul/PocketCats" alt="GitHub contributors">
    </a>
    <a href="https://img.shields.io/github/languages/top/Pauwul/PocketCats">
        <img src="https://img.shields.io/github/languages/top/Pauwul/PocketCats" alt="GitHub top language">
    </a>

</div>

<div  style="display:none" id=description>
description
</div>

#### Collect your friend's cats and vote for the best one! Like _pokemon_. But more _wholesome_. :heart_eyes_cat:

---

</div>

## Table of contents

- [PocketCats](#pocketcats)
- [Description](#description)
- [Table of contents](#table-of-contents)
- [Technologies](#technologies)
- [Features](#features)
  - [Essential UX](#essential-ux)
  - [Opitional UX](#opitional-ux)
- [Installation](#installation)
- [Contributors](#contributors)

## Technologies

#### Frontend :

[![My Skills](https://skillicons.dev/icons?i=nodejs,nextjs,tailwind,figma,ts,electron,&theme=light)](https://skillicons.dev)

#### Backend :

[![My Skills](https://skillicons.dev/icons?i=spring,java,maven,hibernate,express,postgres)](https://skillicons.dev)

#### Infra :

[![My Skills](https://skillicons.dev/icons?i=docker,github,vercel,githubactions,gulp,git)](https://skillicons.dev)

#### Devtools:

[![My Skills](https://skillicons.dev/icons?i=eclipse,idea,vscode,postman,)](https://skillicons.dev)

## Features

### Essential UX

- [ ] Authentication and authorization
  - [ ] Login
  - [ ] Register
  - [ ] Logout
  - [ ] Forgot password
  - [ ] Reset password
- [ ] User profile
  - [ ] Edit profile
  - [ ] Delete profile
- [ ] User's cats page
  - [ ] Add cat
  - [ ] Edit cat
  - [ ] Delete cat
- [ ] Voting page
- [ ] Leaderboard page

### Opitional UX

- [ ] User's friends page
- [ ] User's votes page
- [ ] User's notifications page

## Installation

```bash
git clone https://github.com/Pauwul/PocketCats
docker compose up
```

> Note:
> It's required to have docker installed for this to work.
> Depending on the version of docker and OS, you may need to use:

```bash
docker-compose up # instead of docker compose up
```

What the script above does:

- [ ] Pulls the images for Postgres, Next and Java
- [x] Runs the migrations in the Postgres DB instance, the DB is available at the default Postgres port `localhost:5432`. Use your favorite DB client in order to view and edit the tables.
- [ ] Installs dependencies of the frontend (npm install) and runs the frontend environment (npm run dev) at `localhost:3000`
- [ ] Installs the backend dependencies and runs the backend api at `localhost:8080`. You may use postman in order to test the routes.
- [ ] Docs at `localhost:8080/api` implemented with OpenAPI (formerly known as SwaggerDocs).

## Contributors

![github stats](https://github-readme-stats.vercel.app/api?username=sarah-hart-landolt&show_icons=true&theme=radical)

<a href="https://github.com/Pauwul/PocketCats/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Pauwul/PocketCats"/>
</a>
