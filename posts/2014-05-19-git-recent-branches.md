Title: Git Recent Branches
Data: 2014-05-19 22:03
Tags: gists, git, snippets, programming

Have you ever wanted `git branches` to display all branches sorted by the last
commit date?

Let's say you're working on a project with a lot of branches, you're hopping around topic branches like crazy, and you have the name of that last one you were working on right on the tip of your tongue...

Well, easy enough!

[Use this plugin](https://gist.github.com/gnarmis/63016a8aad4f850e7a09).

It's just a slightly ugly one liner:

    git for-each-ref --sort=-committerdate refs/heads/ --format='%(refname)' | sed 's/refs\/heads\///g'

But if you save this as `git-recent-branches`, make it executable, and put it somewhere accessible on your `$PATH`, you can do this:

    # top 3 recent branches
    git recent-branches | head -n 3

