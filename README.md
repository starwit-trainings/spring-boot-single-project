# Spring Boot Tutorial
This is a Spring Boot tutorial that walks through setting up a full-fledged (albeit simple) web application with many bells and whistles that Spring Boot has to offer. 

## How to use
- Check out the [Exercises](./exercises)
- There are two branches for each exercise: `exercise_*` pointing at the state the project should roughly be in when starting the exercise and `exercise_*_solution` pointing at a (!) solution. There are of course infinitely many ways to implement this project.

## How to change
This repo is structured in a way that makes it possible to fix bugs without having to change them in many different versions of the code. Therefore, there is only one directory and one project that gradually is extended with every exercise. Branches are just used as pointers into the history (which is what git branches naturally are, although this is probably a slight misuse of the concept).\
In order to change something (fix a bug, update a dependency, etc.) you have to do the following:
- Switch to the branch you want to work on (i.e. the earliest branch where your change makes any sense)
- Commit your changes
- Rebase everything on top of your current `HEAD`, thereby rewriting all branches inbetween (luckily, `git rebase` has this very useful feature)\
  `git rebase --update-refs HEAD <the_newest_branch>`\
  (this creates new commits, of course, but I think we can tolerate that in this case)
- Make sure your git history is in the state you want
- Force push all branches\
  `git push --all --force`