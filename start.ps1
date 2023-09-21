New-ItemProperty -Path "HKCU:\SOFTWARE\Microsoft\Windows\CurrentVersion\Themes\Personalize" -Name AppsUseLightTheme -Value 0 -PropertyType DWord -Force
Get-Process chrome | ForEach-Object { $_.CloseMainWindow() | Out-Null}
start chrome -ArgumentList '--new-window https://stech.instructure.com/login/canvas https://discord.com/app https://github.com/login'
winget install Microsoft.VisualStudioCode --accept-package-agreements --accept-source-agreements --override '/SILENT /mergetasks="!runcode,addcontextmenufiles,addcontextmenufolders,addtopath"'
Set-Location "C:\Users\student\Documents"
git clone https://github.com/allancoding/SoftwareDev
git config --global user.name "Allan Niles"
git config --global user.email "allancoding.dev@gmail.com"
Set-Location "C:\Users\student\Documents\SoftwareDev"
start code .
Start-Sleep 1
Get-CimInstance win32_process -Filter "Name like 'conhost.exe'" | ? { (Get-Process -id $_.ParentProcessId -ea Ignore) -eq $null } | Select-Object ProcessId | ? { Stop-Process $_.ProcessId -Force }
exit
