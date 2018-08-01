/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.20-log : Database - tale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tale`;

/*Table structure for table `posts` */

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `content` longtext,
  `permalink` varchar(255) DEFAULT NULL,
  `post_format` varchar(255) NOT NULL,
  `post_status` varchar(255) NOT NULL,
  `post_type` varchar(255) NOT NULL,
  `rendered_content` longtext,
  `rendered_summary` longtext,
  `summary` longtext,
  `title` varchar(255) NOT NULL,
  `views` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`),
  CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `posts` */

/*Table structure for table `posts_tags` */

DROP TABLE IF EXISTS `posts_tags`;

CREATE TABLE `posts_tags` (
  `post_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`post_id`,`tag_id`),
  KEY `FK4svsmj4juqu2l8yaw6whr1v4v` (`tag_id`),
  CONSTRAINT `FK4svsmj4juqu2l8yaw6whr1v4v` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`),
  CONSTRAINT `FKcreclgob71ibo58gsm6l5wp6` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `posts_tags` */

/*Table structure for table `settings` */

DROP TABLE IF EXISTS `settings`;

CREATE TABLE `settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `_key` varchar(255) NOT NULL,
  `_value` longblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1xosmfrlsfuunueyh2walyb7i` (`_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `settings` */

/*Table structure for table `t_attach` */

DROP TABLE IF EXISTS `t_attach`;

CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL DEFAULT '',
  `ftype` varchar(50) DEFAULT '',
  `fkey` varchar(100) NOT NULL DEFAULT '',
  `author_id` int(10) DEFAULT NULL,
  `created` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_attach` */

insert  into `t_attach`(`id`,`fname`,`ftype`,`fkey`,`author_id`,`created`) values 
(1,'Contacts.accdt','file','/upload/2018/07/5e43318cjui6fr72179pl06e9c.accdt',1,1532582461);

/*Table structure for table `t_comments` */

DROP TABLE IF EXISTS `t_comments`;

CREATE TABLE `t_comments` (
  `coid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(10) unsigned DEFAULT '0',
  `created` int(10) unsigned DEFAULT '0',
  `author` varchar(200) DEFAULT NULL,
  `author_id` int(10) unsigned DEFAULT '0',
  `owner_id` int(10) unsigned DEFAULT '0',
  `mail` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `agent` varchar(200) DEFAULT NULL,
  `content` text,
  `type` varchar(16) DEFAULT 'comment',
  `status` varchar(16) DEFAULT 'approved',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`coid`),
  KEY `cid` (`cid`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_comments` */

insert  into `t_comments`(`coid`,`cid`,`created`,`author`,`author_id`,`owner_id`,`mail`,`url`,`ip`,`agent`,`content`,`type`,`status`,`parent`) values 
(1,1,1532511155,'ram',0,1,'r@h.com','','0:0:0:0:0:0:0:1',NULL,'hi ravi','comment','approved',0),
(2,6,1533031382,'raviteja',0,1,'r@h.com','https://github.com/RaviTejaBollimuntha/','0:0:0:0:0:0:0:1',NULL,'Good article','comment','not_audit',0);

/*Table structure for table `t_contents` */

DROP TABLE IF EXISTS `t_contents`;

CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `modified` int(10) unsigned DEFAULT '0',
  `content` text COMMENT 'Content text',
  `author_id` int(10) unsigned DEFAULT '0',
  `type` varchar(16) DEFAULT 'post',
  `status` varchar(16) DEFAULT 'publish',
  `tags` varchar(200) DEFAULT NULL,
  `categories` varchar(200) DEFAULT NULL,
  `hits` int(10) unsigned DEFAULT '0',
  `comments_num` int(10) unsigned DEFAULT '0',
  `allow_comment` tinyint(1) DEFAULT '1',
  `allow_ping` tinyint(1) DEFAULT '1',
  `allow_feed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`cid`),
  UNIQUE KEY `slug` (`slug`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_contents` */

insert  into `t_contents`(`cid`,`title`,`slug`,`created`,`modified`,`content`,`author_id`,`type`,`status`,`tags`,`categories`,`hits`,`comments_num`,`allow_comment`,`allow_ping`,`allow_feed`) values 
(1,'About','about',1487853610,1533031019,'**Author**\r\n\r\n![Author][1]\r\nRavi Teja Bollimuntha, I have written and developed this site so that students may learn computer science related technologies easily. I\'m committed to provide easy and in-depth tutorials on various technologies. No one is perfect in this world and nothing is eternally best. But we can try to be better. I hope it will help you a lot.\r\n\r\n**Javatpoint Services**\r\nJavaTpoint offers too many high quality services. Mail us on hr@javatpoint.com, to get more information about given services.\r\n\r\n - Website Designing\r\n\r\n - Website Development\r\n\r\n - Java Development\r\n\r\n - PHP Development\r\n\r\n - WordPress\r\n\r\n - Graphic Designing\r\n\r\n - Logo\r\n\r\n - Digital Marketing\r\n\r\n - On Page and Off Page SEO\r\n\r\n - PPC\r\n\r\n - Content Development\r\n\r\n - Corporate Training\r\n\r\n - Classroom and Online Training\r\n\r\n - Data Entry\r\n\r\n**Training For College Campus**\r\nJavaTpoint offers college campus training on Core Java, Advance Java, .Net, Android, Hadoop, PHP, Web Technology and Python. Please mail your requirement at raviteja.bollimuntha@gmail.com\r\nDuration: 1 week to 2 week\r\n\r\n\r\n  [1]: https://www.colourbox.com/preview/5744343-e-learning-concept-on-white-background.jpg',1,'page','publish',NULL,NULL,0,0,1,1,1),
(7,'Python Developer article','python',1533068094,1533111971,'**Hello Developers. Meet Python. The King of Growth**\r\nFor the most part, it’s difficult to crown just one language as the supreme leader of standard use in the development world. There isn’t a language that takes the cake, though there are developers that certainly prefer one or more over the others. Growth is not surprising to see anymore either, especially in today’s highly virtual and digitized world. Technologies like AI, automation, machine learning, mobile and web design all favor development which in turn feeds the demand for more programmers and development professionals.\r\n\r\n\r\n That said, if there’s only one language you select to learn due to its incredible potential let it be Python. Why? We’re going to take a closer look at the incredible rise Python is seeing right now, especially in high-income and development-heavy countries.\r\n\r\n\r\n Python, at least right now, can be considered the king of growth in the language and development space. Lofty claim? Don’t believe it? No problem, let’s dive in and find out why we’re saying such a thing.\r\n\r\n\r\n **What Are “High-Income” Countries?**\r\n\r\n First, we need to define “high-income” countries and why that’s an important distinction to make when looking at current trends and statistics.\r\n\r\n\r\n High-income countries include those where it’s fairly common to earn a wage or salary that meets the industry average; usually this falls somewhere between $60,000 to $140,000, but depends on the country in question.\r\n\r\n\r\n The most common countries included in this demographic are United States, United Kingdom, Germany, and Canada. Keep in mind, these are not the only major contributors in the global software development industry. Just as impactful are Russia, China, Brazil, and many others - though they certainly lack in salary and wage offerings.\r\n\r\n\r\n And while Python is showing growth in all these markets, it’s the high-income markets that are showing the most influential numbers.\r\n\r\n\r\n **How the Growth Was Measured**\r\n\r\n As reported by David Robinson on the Stack Overflow blog, you can use the platform’s Trends tool to view and measure growth of various development languages, for which Python is no exception.\r\n\r\n\r\n Out of five major languages - also CSS, HTML, Android, and JQuery - Python is seeing incredible growth in high-income countries, going all the way back to 2011. In June 2017, Python became the most visited tag on Stack Overflow, among high-income countries. That’s an impressive sight, compared to 2012 when it was the least visited tag of the five languages. In just five years, popularity for the language has more than doubled.\r\n\r\n\r\n Robinson does go on to explain some underlying reasons why this change happened. Java has seasonal traffic thanks to educational purposes, for example. Still, there’s no denying the growth of Python.\r\n\r\n\r\n He’s not the only one to make this discovery, however. Others have noticed Python’s rise in popularity in the past, including a report from Dice back in 2014. \r\n\r\n\r\n Jeff Knupp a renowned Python developer seems to think that the growth is happening - and accelerating - simply because of one feature, Python’s Buffer Protocol. Knupp argues the low-level API offers zero-copy access to memory and large amounts of stored data, which lends itself well to data scientists. Why is that important? Well, because nearly everything is driven by big-data, analytics, intelligence, and machine learning these days. It makes sense why we’d see a focus on languages that not only make these processes easier, but more efficient.\r\n\r\n\r\n Will that change anytime soon, though? Looking at the Stack Overflow trends report again, it’s easy to see that Python will be one of the most popular throughout 2018, as well.\r\n\r\n\r\n **How You Can Get Involved with Python?**\r\n\r\n Clearly, it’s time to get onboard if you’ve considered learning or working with Python in the past. The average salary of a Python developer, for instance, is climbing. Starting at about 85K in 2014 and jumping to $120K and beyond in silicon valley markets.\r\n\r\n\r\n Start with our free beginner’s tutorial and coding guide. You’ll learn the benefits offered by the language, how you can set up and work with the environment, and how to work with frameworks like Django. It closes out by walking you through 6 projects, which you can complete in your free time, teaching you how to work with and shape the code.\r\n\r\n\r\n From there, it’s up to you. We recommend checking out courses on Treehouse, of course. But you can go through any training or regimen you prefer. At the end of the free tutorial, you should have enough knowledge to decide where to go next, if not right into developing basic apps with the language.',1,'post','publish','Python','default',0,0,1,1,1),
(8,'Best Sites For Java Learners','java-sites',1533068199,1533111992,'Top 10 Java Blogs for Programmers of All Levels\r\n-----------------------------------------------\r\n\r\nThe world of information technology is an ever-changing landscape. Simply thinking back to the infrastructure and functions of a webpage 5, 10, 15 years ago can make any programmer cringe. Staying current on industry strategies and best practices is essential for developers of all levels.\r\n\r\nBlogs can provide great insight and perspective from industry peers and colleagues. All over the world, Java professionals are posting daily about new findings or new feature functions. Unfortunately, blogs can also provide some not so great insight and perspective. With such an overabundance of voices trying to earn your attention, it can be difficult to find the good, from the bad and the ugly.\r\n\r\nLuckily, we are here to help. We’ve searched high and low and found some of the most credible, unique, and just plain awesome communities and experts talking about all things Java. Whether you’re a 15-year Java artisan or interested in entering the world of programming for the first time, we have a resource for you.\r\n\r\n**Top 10 Java Blogs**\r\n**Vlad Mihalcea**\r\nVlad Mihalcea is a world-class Java expert and a highly respected mentor of the craft. Dating back to 2014, Vlad has been a dedicated blogger and teacher, and currently reaches about 75k visitors a month. Most recently, Vlad has been taking a look at Hibernate and identifying new tips, tricks, and best practices. With a wide variety of articles, there is information available for developers of any level.\r\n\r\nVlad’s blogs have been such a success, he was able to cultivate existing articles and create new content to write the book High-Performance Java Persistence. In the book, Vlad looks into Java data access performance tuning, and discusses connection management, batch updates, fetch sizes and the most common Java data access frameworks.\r\n\r\nVlad’s blog is a must stop for anyone interested in continual Java learning, new weekly published articles, and a soon-to-be released video training course. \r\n\r\n**Adam Bien**\r\nAdam Bien is potentially the most informative man on the planet when it comes to Java, and thankfully for all of us, he likes to talk about it. Adam has been working with Java since JDK 1.0 in 1995. Since then, Adam has written 1669 (and counting) blog articles with literally thousands of daily readers. Adam discusses JavaFX, Java EE (and more) nowadays, and has several books available as well. Adam also consistently puts on web events and workshops, all of which are incredibly interactive and user-friendly.\r\n\r\nMost of his blog posts include videos to follow along, which makes his teachings even more useful. Adam admits he’s not a professional writer nor speaker, which actually makes his work feel even more authentic and real.\r\n\r\n**InfoQ**\r\nIn contrast to other blogs on this list, InfoQ is a central hub of everything a developer could hope to find. InfoQ acts as a communal site for news, updates, articles and how-to guides. This is reflected in the InfoQ mantra: facilitating the spread of knowledge and innovation in professional software design. Hundreds of writers and contributors provide content to the site, which gives the readers a wide variety of information and perspectives. The main focus of InfoQ includes:\r\n\r\nDevelopment (including Java, JavaScript, Scala, and more)\r\nArchitecture & Design\r\nData Science\r\nCulture & Methods (including diversity, leadership, and testing)\r\nDevOps\r\nWhether you are just starting out in Java, a seasoned veteran, or anything in between, InfoQ is a fantastic source to learn and engage with fellow industry members and advocates.\r\n\r\n \r\n\r\n**Javarevisited**\r\nIf you are looking for specific Java how-to’s and step-by-step Java guides, Javarevisited is exactly what you want. Run by a man named Javin Paul with 7 years industry experience, Javarevisited is a blog focusing on Java programming language, FIX protocol and Tibco RV. Javarevisited is a fantastic resource for both beginners and experienced programmers.\r\n\r\nOne of Javin’s more popular blog series stem from reader interviews. Readers are encouraged to conduct interviews with Javin, picking his brain about all things Java. Javin then takes his personal favorite questions, and turns them into deep, expansive articles. Javarevisited has hundreds of Java articles available with fresh content coming out multiple times a week.\r\n\r\n**Baeldung**\r\nBaeldung is a fantastic source for anyone interested in the latest programming news, updates and advice. Baeldung focuses specifically on Java, Persistence, REST API’s, Jackson and HttpClient information, providing learning courses, how-to guides, and articles from multiple writers. One of the biggest benefits to Baeldung is the high volume of quality information being posted. Often multiple articles are posted every day.\r\n\r\nBaeldung’s newsletter, The Java Weekly, is an absolute most read resource. It focuses on a number of categories and provides links to articles and news updates, both from Baeldung’s site and other sources. For example, the most recent newsletter focuses on Spring and Java, Technical tips, Musings, and a few entertaining comics for the nerd in all of us.\r\n\r\n**Miles to Go**\r\nArun Gupta is the man behind the legendary blog Miles to Go, and may quite possibly be the most interesting man in the tech world. Arun is a jack of all trades, whose resume includes, but is not limited to: Java Champion, JavaOne rock star, Minecraft Modder, avid runner, and best-selling author. Oh yeah, and he also works as a Principle Open Source Technologist at Amazon Web Services.\r\n\r\nOn his blog, Arun touches on anything and everything pertaining to a programmer. Some of his most popular topics include Java, Java EE, AWS, WildFly, and Couchbase. While the frequency of posts on Miles to Go tend to be a bit more sporadic than other Java blogs mentioned, the quality of work is as high as it gets. Arun is an incredibly knowledgeable man and explains his material in a clear, concise, and easy-to-follow manner.\r\n\r\nMiles to Go is a blog you come to for the programming knowledge and end up staying for Arun’s marathon times (which, by the way, is up to 20+ marathons).\r\n\r\n**jOOQ**\r\njOOQ Blog focuses exclusively on Java, SQL and jOOQ which allows the writer to be highly specialized in these specific topics and programs. Consisting mostly of step-by-step guides and how-to’s, programmers of all levels can benefit massively from the huge library of information available. The sidebar allows readers to easily navigate to different categories, such as SQL Tricks and Tips, Thoughts on Programming, Java and Other Languages, and jOOQ. The frequency of posts on jOOQ Blog is also more on the sporadic side of the spectrum, but with such a vast library of information as is, this should be no problem at all.\r\n\r\n**Thoughts on Java**\r\nIndustry expert and influencer Thorben Janssen is the mastermind behind Thoughts on Java, which is much more than a simple blog. Thorben has been working in the field for 15 years and specializes in all things related to Hibernate. Thoughts on Java is a source for all Java skill levels thanks to the highly specific blogs and guides, YouTube videos, workshops, and online courses. Quick, easy-to-read Hibernate tips are available for common developments tasks. The videos, which are narrated by Thorben himself, dive deeper in Hibernate concepts and features.\r\n\r\nPlus, signing up as a Thoughts on Java member provides you with Java cheat sheets, downloadable ebooks and printable Hibernate tips. Thorben recently guest blogged on the Stackify blog, taking a look at the nine best practices to handle exceptions.\r\n\r\n**A Java Geek**\r\nMore experienced programmers will greatly benefit from Nicolas Frankel’s blog, A Java Geek. Nicolas provides a refreshing, unique perspective on most things related to programming, but tends to focus specifically on Java, Java EE and Spring technologies. A Java Geek also dives into Software quality, build processes, and Rich internet applications.\r\n\r\nBlog posts tend to be less explanation-based, and more perspective and opinion pieces about the craft of programming. While the site is a bit tougher to navigate, anyone experienced in the industry will certainly appreciate what Nicolas has to offer.\r\n\r\n**JavaWorld**\r\nJavaWorld is exactly what you would expect it to be based on its name: the ultimate Java hub. JavaWorld is the leading independent resource for enterprise Java developers, architects and managers who want to stay up-to-date and learn more about Java-related technologies. JavaWorld is a community for like-minded programmers, exploring everything from learning Java basics, to open source Java, all the way to programming career news and opportunities.\r\n\r\nBecause of the wide range of information, Javaworld is an ideal starting point for those new to programming. The Java 101 blog series was designed with Java beginners in mind, and tackles topics related to Java programming, syntax, API’s, and packages. If you aren’t sure what those programs and tools are exactly, JavaWorld is the place for you. For more experienced programmers, JavaWorld posts articles regarding recent updates, such as Java EE 8 and other new tools that would provide valuable insight and opinions from industry experts.\r\n\r\nAs updates and features come and go, we see further proof of the need for constant communication between industry peers to stay current with Java, Jave EE, SQL and other tools we use daily. It’s one thing to talk to the developer in the office next to you, but that doesn’t quite compare to interacting with a best-selling author from Germany, or a marathon-running Minecraft modder from California. Hopefully these resources were helpful to you and one or two made it onto your bookmarks bar.\r\n\r\nAt Stackify, we are dedicated to helping developers grow, learn, and perfect their programming skills. Check out our Java resources to find tips, tricks, and guides to help you become a better Java developer.',1,'post','publish','java,java blogs,sites','java',0,0,1,1,1);

/*Table structure for table `t_logs` */

DROP TABLE IF EXISTS `t_logs`;

CREATE TABLE `t_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `action` varchar(100) DEFAULT NULL,
  `data` varchar(2000) DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `created` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_logs` */

insert  into `t_logs`(`id`,`action`,`data`,`author_id`,`ip`,`created`) values 
(1,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532580250),
(2,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532580713),
(3,'Save system settings','{\"site_record\":\"\",\"site_description\":\"13 Blog\",\"site_title\":\"My Blog\",\"site_theme\":\"default\",\"allow_install\":\"\"}',1,'0:0:0:0:0:0:0:1',1532581823),
(4,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532582392),
(5,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532830840),
(6,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532867056),
(7,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532867058),
(8,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532874240),
(9,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532874241),
(10,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532937192),
(11,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532937398),
(12,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532937400),
(13,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532937645),
(14,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532948775),
(15,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532948786),
(16,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532948786),
(17,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532948787),
(18,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532948793),
(19,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532964915),
(20,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1532965612),
(21,'Modify Personal Information','{\"uid\":1,\"email\":\"1034683568@qq.com\",\"screenName\":\"RaviTeja\"}',1,'0:0:0:0:0:0:0:1',1532965681),
(22,'\r\nDelete article','1',1,'0:0:0:0:0:0:0:1',1532971036),
(23,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533009977),
(24,'Delete article','3',1,'0:0:0:0:0:0:0:1',1533012162),
(25,'Delete article','2',1,'0:0:0:0:0:0:0:1',1533012170),
(26,'Save system settings','{\"site_record\":\"18456925525\",\"site_description\":\"Online Leaning\",\"site_title\":\"RS E-Learning Industry\",\"site_theme\":\"default\",\"allow_install\":\"\"}',1,'0:0:0:0:0:0:0:1',1533020180),
(27,'System backup',NULL,1,'0:0:0:0:0:0:0:1',1533021387),
(28,'Modify Personal Information','{\"uid\":1,\"email\":\"raviteja.bollimuntha@gmail.com\",\"screenName\":\"RaviTeja\"}',1,'0:0:0:0:0:0:0:1',1533027222),
(29,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533029993),
(30,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533030574),
(31,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533030962),
(32,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533067905),
(33,'Delete article','6',1,'0:0:0:0:0:0:0:1',1533067993),
(34,'Delete article','5',1,'0:0:0:0:0:0:0:1',1533067999),
(35,'Login background',NULL,1,'0:0:0:0:0:0:0:1',1533111226);

/*Table structure for table `t_metas` */

DROP TABLE IF EXISTS `t_metas`;

CREATE TABLE `t_metas` (
  `mid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `type` varchar(32) NOT NULL DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  `sort` int(10) unsigned DEFAULT '0',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_metas` */

insert  into `t_metas`(`mid`,`name`,`slug`,`type`,`description`,`sort`,`parent`) values 
(1,'default',NULL,'category',NULL,0,0),
(8,'Java programer Article','Java programer Article','tag',NULL,0,0),
(9,'java','java','tag',NULL,0,0),
(10,'java atricle','java atricle','tag',NULL,0,0),
(11,'java',NULL,'category',NULL,0,0),
(12,'spring boot',NULL,'category',NULL,0,0),
(13,'spring',NULL,'category',NULL,0,0),
(14,'GItHUb','https://github.com/RaviTejaBollimuntha/','link','https://avatars3.githubusercontent.com/u/33811517',2,0),
(15,'GitHub','https://github.com/RaviTejaBollimuntha/FS-Blog-master','link','https://blog.aifsabroad.com/wp-content/uploads/2016/01/AIFSabroad-logo.png',1,0),
(16,'javatest','javatest','tag',NULL,0,0),
(17,'java blogs','java blogs','tag',NULL,0,0),
(18,'sites','sites','tag',NULL,0,0),
(19,'Python','Python','tag',NULL,0,0);

/*Table structure for table `t_options` */

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '',
  `value` varchar(1000) DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_options` */

insert  into `t_options`(`name`,`value`,`description`) values 
('allow_install','',NULL),
('site_description','Online Leaning',NULL),
('site_keywords','13 Blog',NULL),
('site_record','18456925525','case number'),
('site_theme','default',NULL),
('site_title','RS E-Learning Industry',''),
('social_github','',NULL),
('social_twitter','',NULL),
('social_weibo','',NULL),
('social_zhihu','',NULL);

/*Table structure for table `t_relationships` */

DROP TABLE IF EXISTS `t_relationships`;

CREATE TABLE `t_relationships` (
  `cid` int(10) unsigned NOT NULL,
  `mid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cid`,`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_relationships` */

insert  into `t_relationships`(`cid`,`mid`) values 
(7,1),
(7,19),
(8,9),
(8,11),
(8,17),
(8,18);

/*Table structure for table `t_users` */

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `home_url` varchar(200) DEFAULT NULL,
  `screen_name` varchar(32) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `activated` int(10) unsigned DEFAULT '0',
  `logged` int(10) unsigned DEFAULT '0',
  `group_name` varchar(16) DEFAULT 'visitor',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`username`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_users` */

insert  into `t_users`(`uid`,`username`,`password`,`email`,`home_url`,`screen_name`,`created`,`activated`,`logged`,`group_name`) values 
(1,'admin','f6fdffe48c908deb0f4c3bd36c032e72','raviteja.bollimuntha@gmail.com',NULL,'RaviTeja',1490756162,0,0,'visitor');

/*Table structure for table `tags` */

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t48xdq560gs3gap9g7jg36kgc` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tags` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`created_at`,`updated_at`,`email`,`password`,`role`) values 
(1,'2018-07-27 09:24:05','2018-07-27 09:24:05','admin','c73e6415431cde857c6744aa2eb0d1c4e57435c5dfe591fbb7dcf1fa23ce7fc143a3ab887619c7e3','ROLE_ADMIN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
