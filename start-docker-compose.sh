#!/bin/bash

# docker-compose doesn't work with argument passed by shell command very well, so create temparary variables and pass them to docker-compose up.
# variable for MS_WORKPACKAGE
export MS_WORKPACKAGE_HOME=$(pwd)/ms-workpackage
export MS_TASK_HOME=$(pwd)/ms-task
export MS_TOOL_HOME=$(pwd)/ms-tool


export UID=$UID

docker-compose up

