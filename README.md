# medaware_test
## This is the test task for medaware

Requirements: 
* Docker 
* docker volumes created
* In order to create docker volumes you can use following commands
``` dockerfile 
docker volume create --name medaware_result --opt type=none --opt device={PATH_TO_RES_FOLDER} --opt o=bind
docker volume create --name medaware_logs --opt type=none --opt device={PATH_TO_LOGS_FOLDER} --opt o=bind
```
## Launch project
In order to launch the project please run following command
```
docker compose up
```
The result of the program will appear in the mounted folder provided in PATH_TO_RES_FOLDER

## Jupyter notebook
Inside the project there is [jupyter notebook file](src/main/resources/noise_reduction.ipynb) 
This file was created to remove the noise from [input file](src/main/resources/task1_input) 
As a result of this script [file without noise](src/main/resources/task1_output.txt) was created. Which was later used in main project