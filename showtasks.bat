call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runwebbrowser
echo.
echo runcrud errors
goto fail

:runwebbrowser
timeout 10
start chrome http://localhost:8083/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo There were errors in opening brave
goto fail

:fail
echo.
echo There were errors in showtasks.bat

:end
echo.
echo Showtasks work is finished