@echo off
echo {"
FOR %%i IN (*.*) DO (
	echo %%i
	echo ","
)
echo }
pause