winget install Microsoft.VisualStudioCode --accept-package-agreements --accept-source-agreements --override '/SILENT /mergetasks="!runcode,addcontextmenufiles,addcontextmenufolders,addtopath"'
Set-Location "C:\Users\student\Documents"
git clone https://github.com/allancoding/SoftwareDev
git config --global user.name "Allan Niles"
git config --global user.email "allancoding.dev@gmail.com"
Set-Location "C:\Users\student\Documents\SoftwareDev"
Set-Content C:\Users\student\AppData\Roaming\Code\User\settings.json '{"git.enableSmartCommit": true,"git.confirmSync": false,"git.autofetch": true,"workbench.colorTheme": "Default Dark Modern","redhat.telemetry.enabled": true,"github.copilot.enable": {"*": true,"plaintext": false,"markdown": true,"scminput": false},"remoteHub.commitDirectlyWarning": "off","explorer.confirmDragAndDrop": false,"files.autoSave": "afterDelay","window.newWindowDimensions": "fullscreen","security.workspace.trust.enabled": false}'
Start-Process -FilePath "C:\Users\student\AppData\Local\Programs\Microsoft VS Code\Code.exe" -ArgumentList "."
exit