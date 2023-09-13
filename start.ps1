winget install Microsoft.VisualStudioCode --accept-package-agreements --accept-source-agreements --override '/SILENT /mergetasks="!runcode,addcontextmenufiles,addcontextmenufolders,addtopath"'
Set-Location "C:\Users\student\Documents"
git clone https://github.com/allancoding/SoftwareDev
git config --global user.name "Allan Niles"
git config --global user.email "allancoding.dev@gmail.com"
Set-Location "C:\Users\student\Documents\SoftwareDev"
#Set-Variable classpath=.;%classpath%;C:\Users\student\Documents\SoftwareDev\lib\junit.jar
Start-Process -FilePath "C:\Users\student\AppData\Local\Programs\Microsoft VS Code\Code.exe" -ArgumentList "."
exit