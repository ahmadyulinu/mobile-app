# mobile-app - Project UAS PAM
Aplikasi Julio Fish Betta Compannion. \
*abaikan branch **master***
# Table of Contents
- [mobile-app - Project UAS PAM](#mobile-app---project-uas-pam)
- [Table of Contents](#table-of-contents)
- [Setting Up](#setting-up)
  * [Clone Repository](#clone-repository)
  * [Fetch dan pull biar up-to-date](#fetch-dan-pull-biar-up-to-date)
- [Development](#development)
  * [Buat branch baru](#buat-branch-baru)
  * [Merging branch](#merging-branch)
    + [Commit seluruh perubahan yang anda lakukan](#commit-seluruh-perubahan-yang-anda-lakukan)
    + [Kembali ke branch main](#kembali-ke-branch-main)
    + [Merge dua branch](#merge-dua-branch)
    + [Push branch main yang telah dimerge ke repo.](#push-branch-main-yang-telah-dimerge-ke-repo)
# Setting Up
## Clone Repository
`git clone https://github.com/ahmadyulinu/mobile-app.git`
## Fetch dan pull biar up-to-date
`git fetch` \
`git pull origin main`

# Development
## Download Gradle
`gradle v6.6.1 https://gradle.org/releases/`
## Buat branch baru
`git checkout -b branch-name`
## Merging branch
### Commit seluruh perubahan yang anda lakukan
`git add .` \
 git commit -m "commit message`
### Kembali ke branch main
`git checkout main`
### Merge dua branch
`git merge branch-name`
### Push branch main yang telah dimerge ke repo.
`git push origin main`
