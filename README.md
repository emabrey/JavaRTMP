#JavaRTMP [![Build Status](https://travis-ci.org/emabrey/JavaRTMP.png)](https://travis-ci.org/emabrey/JavaRTMP)

JavaRTMP is a pure Java client implementation of the [Real Time Messaging Protocol][rtmp-wiki-article-link] licensed via the [MIT License][project-license-file] and copyrighted by Emily Mabrey. The project is being developed because the available options for accessing RTMP streams via Java are unsatisfactory due to problems such as unfavorable licenses, sparse or nonexistent documentation and unit tests, abandonment of active development, or generally incorrect or incomplete implementations.

##Project Goals
  - 100% test coverage of all branches without failing or skipping tests
  - complete documentation of all methods, classes, and packages
  - compliance with the official [RTMP][rtmp-wiki-article-link] and [AMF][amf-wiki-article-link] standards
  - better performance than alternatives (such as [Flazr][flazr-project-link] or [librtmp][librtmp-project-link])
  - a deterministic Maven build which produces obfuscated, minimized and signed binaries
  - automatic distribution of `RELEASE` project binaries and documentation to Maven Central repository
  - automatic distribution of `SNAPSHOT` project binaries to the Sonatype OSS repository
  - automatic generation of a project site containing up-to-date reports on the project

##How to Contribute

Before making your first contribution, please read [the rules and instructions][contribution-rules-link]. Once you have familiarized yourself with those standards, please feel free to submit fixes via [a pull request][pull-request-link] or contribute additional information to [the project wiki][project-wiki-link]. If you notice an issue please [submit a bug report][project-issues-link], but please attempt to verify that you are not duplicating an already reported issue.

You can view a list of those recognized for their assistance with the project [here][project-recognition-link]. To all those who help make JavaRTMP a reality, from users to contributors, thank you so much!

##Project Information

Current information on the project is available at [the JavaRTMP project site][project-site-link]. As the project is currently working towards an initial release, the information on the site is volatile and subject to change without warning. The travis-ci service verifies the build status of the project whenever the project's GitHub repository is modified; you can view the status of each branch [here][project-ci-link].

[rtmp-wiki-article-link]: https://wikipedia.org/wiki/Real_Time_Messaging_Protocol
[amf-wiki-article-link]: https://wikipedia.org/wiki/Action_Message_Format
[flazr-project-link]: http://www.flazr.com
[librtmp-project-link]: https://rtmpdump.mplayerhq.hu/librtmp.3.html
[project-license-file]: LICENSE.md
[contribution-rules-link]: https://github.com/emabrey/JavaRTMP/wiki/Contribution-Rules-and-Instructions
[pull-request-link]: https://github.com/emabrey/JavaRTMP/compare/
[project-wiki-link]: https://github.com/emabrey/JavaRTMP/wiki/
[project-issues-link]: https://github.com/emabrey/JavaRTMP/issues/new
[project-recognition-link]: https://emabrey.github.io/JavaRTMP/team-list.html
[project-site-link]: https://emabrey.github.io/JavaRTMP/
[project-ci-link]: https://travis-ci.org/emabrey/JavaRTMP
