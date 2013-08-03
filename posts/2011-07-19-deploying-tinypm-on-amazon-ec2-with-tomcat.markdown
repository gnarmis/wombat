---
layout: post
title: Deploying TinyPM on Amazon EC2 with Tomcat
date: 2011/07/19 20:04:00 -0700
tags: webdev, devops
---


I had a particularly interesting time trying to install TinyPM, which
is a Java-based project management solution. After searching el goog
for a bit, I couldn't find an exact walkthrough or recipe, so I
decided to make one here for anyone else who's looking into doing the
same.

First, the platform. I chose Amazon's Elastic Computing Cloud (EC2),
although you could easily opt for Rackspace or one of the many Java
hosts (Oxxus seemed compelling too). EC2 has a free usage tier that
fit the needs of the project so I decided to go with it.

Amazon's EC2 allows you to select disk images, called AMI's (Amazon
Machine Image), and then install and run them seamlessly. You can spin
up multiple instances rapidly and manage every last detail about them.
Access to these AMI's (what requests can go to them and from them) is
controlled by Security Groups, which need to be applied to instances.
In the free-tier, you can't change a security group after selecting it
at instance-creation-time. Also, there are a lot of
community-submitted AMI's that you can use as well.

After logging in with my pre-existing Amazon AWS account, I went to
the [AWS management console][1] and selected EC2.

Oh, cool! This console has a lot of options. You can actually launch
your very own server instance by following a simple wizard.

Ok, now that the platform has been selected and introduced, the next
step is to select a good, base AMI that does most of the work for us.
The AMI I used was the [Bitnami Tomcat stack][2] (ami-0eec1167), which
is publicly available and can be used with the free-tier.

Now, I launched the instance-creation wizard from the AWS console.

As you can see, I entered the specific AMI id and then proceeded to
select the search item that matched.

Next, you need to select the first few configuration items about the
new instance:


The defaults should suffice. After that, you can optionally enter some
unique key/value pairs for your own purposes.

And now comes a very important step, making and downloading your key.
You need to give a unique name and then download the given key to your
computer. This key will be used to SSH into your instance.

Most importantly, you need to define the Security Group to be used
with your instance. Remember, if you're doing free-tier, this cannot
be changed later. For the different rules, add a Custom TCP rule for
0.0.0.0/0 with port 8080, an HTTP rule for 0.0.0.0/0, and a Custom TCP
rule for 0.0.0.0/0 for port 22. Make sure the SSH port 22 rule shows
up in the group's definition.



You should now have a functioning EC2 instance. Awesome! Now, SSH into
that baby:

```
$ cd path/to/folder/containing/key 
$ ssh -i ./ bitnami@
```

Replace with your key and with the instance's public dns name (look in
details). Also, you can right-click on the instance in the AWS console
and select "Connect" to get your own personal ssh command.

_**Note**: the root user for this AMI is manager/bitnami (check
[bitnami FAQ][3] for details). I tend to log in with the bitnami user
to my instance and then use sudo for any admin commands._

A bit of an overview about Tomcat and TinyPM:

The webapps folder is like www in Apache. Individual WAR files can be
unzipped into folders inside webapps to deploy them. The environment
variable $CATALINA_HOME points to the root tomcat directory. Also, any
.jar files that are dependencies go in the lib folder. The
installation procedure that can now be followed is [here][4].

After you're logged in, do the following:

```
$ Java -server -Xms256m -Xmx512m -XX:MaxPermSize=96m -XX:+UseParallelGC 
$ cd /opt/bitnami/apache-tomcat/webapps 
$ wget http://www.tinypm.com/downloads/tinypm-2.5.6-tomcat6.0.zip
$ sudo unzip tinypm-2.5.6-tomcat6.0.zip 
$ /opt/bitnami/apache-tomcat/bin/shutdown.sh 
$ mkdir tinypm
$ sudo unzip tinypm.war -d tinypm 
$ sudo cp dependency/* ../lib
```

At this point, you have downloaded and installed the WAR file, taking
care to shutdown Tomcat first. You've also moved TinyPM's dependencies
to Tomcat's lib folder (you already have the mysql-java connector
dependency fulfilled by the bitnami stack).
  
 Next, you need to setup the mysql database. To do this, follow the
 directions for the database setup [here][4]. I kept the defaults just
 to keep things simple. If you change something, it can easily be
 accounted for in the hibernate.properties files under
 webapps/tinypm/WEB-INF/classes.

After that is done, you need to edit the file at
$CATALINA_HOME/webapps/tinypm/WEB-INF/classes/hibernate.properties so
as to uncomment the line:

```
#hibernate.search.default.indexBase = /var/search_index/tinypm
```

by removing the `#` sign. You might need to change permissions by
doing:

```
$ sudo chmod +w hibernate.properties
```

Now, the next step is to create the folder that the above uncommented
line mentions:

```
$ sudo mkdir /var/search_index /var/search_index/tinypm
$ chown -R root /var/search_index/tinypm
```

Finally, start your Tomcat server:

```
$ /opt/bitnami/apache-tomcat/bin/startup.sh
```

And point your browser to /tinypm. The credentials are admin/admin.

Hope this is helpful for someone out there!


[1]: https://console.aws.amazon.com/

[2]: http://bitnami.org/stack/tomcatstack

[3]: http://bitnami.org/faq/cloud_amazon_ec2

[4]: http://documentation.tinypm.com/display/DOC/Tomcat+6.0.x+%28from+WAR+file%29
