Get-Process chrome | ForEach-Object { $_.CloseMainWindow() | Out-Null}
start chrome -ArgumentList '--new-window https://stech.instructure.com/login/canvas https://discord.com/app https://github.com/login'
winget install Microsoft.VisualStudioCode --accept-package-agreements --accept-source-agreements --override '/SILENT /mergetasks="!runcode,addcontextmenufiles,addcontextmenufolders,addtopath"'
Set-Location "C:\Users\student\Documents"
git clone https://github.com/allancoding/SoftwareDev
git config --global user.name "Allan Niles"
git config --global user.email "allancoding.dev@gmail.com"
Set-Location "C:\Users\student\Documents\SoftwareDev"
#Set-Variable classpath=.;%classpath%;C:\Users\student\Documents\SoftwareDev\lib\junit.jar
Start-Process -NoNewWindow -FilePath "C:\Users\student\AppData\Local\Programs\Microsoft VS Code\Code.exe" -ArgumentList "."
