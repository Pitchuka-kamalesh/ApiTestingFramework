@echo on
mvn clean test
pause
cd reports/extent
pause
start "" "report.html"
pause
cd ../..
pause