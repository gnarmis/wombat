Title: Sass and CoffeeScript - Compile and Watch Files with One Command
Date: 2011/08/09 14:30:00 -0700
Tags: projects, coffeescript, sass, webdev, bash


Do you use Sass and CoffeeScript? Tired of remembering and typing out the compile 
and watch commands on both of those command-line utilities? I used to do:

  

    $ compass watch   
    $ coffee -o scripts/ -cw coffee/


...on all of my projects, in separate tabs on the terminal. There had to be 
an easier way.

Do them both, with the standard configuration, using the script below. 


  #!/bin/bash
  # run `compass watch` at pwd
  # run `coffee -o scripts/ -cw coffee/` at pwd
  type -P compass &>/dev/null  || { echo "Compass command not found."; exit 1; }
  type -P coffee &>/dev/null  || { echo "Coffee command not found."; exit 1; }

  if [ ! -d sass/ ] || [ ! -d scripts/ ]
  then
    echo "Project not setup correctly! Put sass files in sass/ and coffee in coffee/"
  else
    if [ ! -d stylesheets/ ]
    then
      mkdir stylesheets
    fi
    if [ ! -d scripts/ ]
    then
      mkdir scripts
    fi
    echo "Watching changes in sass/ and coffee/ and compiling to stylesheets/ and scripts/ ..."
    `compass watch --quiet` &
    `coffee -o scripts/ -cw coffee/` &
    wait
  fi


Add the script into your project, do


    $ chmod +x sassycoffee.sh


to make it executable, and forget about it! I'm planning on some edits in the 
future, but it works well enough and gets the job done. Now, all you need to 
do is:


    $ ./sassycoffee.sh


This was a quick little hack in bash but pretty helpful for my workflow.

Tips? Improvements? I'd be glad to hear 'em.

Update: https://github.com/gnarmis/SassyCoffee


