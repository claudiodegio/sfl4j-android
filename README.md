[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-sfl4j--android-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5146)

# sfl4j implementation for android

The libray support sfl4j for android platform al the moment not suport Mapped Diagnostic Context (MDC) support

# How include

TODO ....

# How configure

To configure log level create a configuration file called 'slf4j-android.properties' into assets app directory like the sample reported below:
```properties
# slf4j-android.properties
# ROOT level
# ERROR,WARN,INFO,DEBUG,TRACE,NONE,ALL
LEVEL=ALL

# Set log level to a given logger name/package
my.package.LEVEL=INFO
```

# License

      Copyright 2015 Claudio Degioanni

      Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
      You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
      See the License for the specific language governing permissions and
      limitations under the License.