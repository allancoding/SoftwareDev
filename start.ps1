if (!([Security.Principal.WindowsPrincipal][Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole] "Administrator")) {
    $scriptBlock = {
        winget source reset --force
        winget settings --enable BypassCertificatePinningForMicrosoftStore
    }
    $elevatedProcess = Start-Process powershell.exe -ArgumentList "-NoProfile -ExecutionPolicy Bypass -Command & { $scriptBlock }" -Verb RunAs -PassThru
    $elevatedProcess.WaitForExit()
    New-ItemProperty -Path "HKCU:\SOFTWARE\Microsoft\Windows\CurrentVersion\Themes\Personalize" -Name AppsUseLightTheme -Value 0 -PropertyType DWord -Force
    Get-Process -Name "chrome" | ForEach-Object { $_.CloseMainWindow() } -ErrorAction SilentlyContinue
    Start-Process "chrome" -ArgumentList "--new-window", "https://stech.instructure.com/login/canvas", "https://discord.com/app", "https://github.com/login", "chrome://settings/security"
    Start-Process ms-settings:personalization-colors
    Invoke-WebRequest -Uri "https://winget.azureedge.net/cache/source.msix" -OutFile "source.msix"
    Add-AppxPackage -Path ".\source.msix"
    winget install Microsoft.VisualStudioCode --accept-package-agreements --accept-source-agreements --override '/SILENT /mergetasks="!runcode,addcontextmenufiles,addcontextmenufolders,addtopath"'
    Set-Location "C:\Users\student\Documents"
    git clone https://github.com/allancoding/SoftwareDev
    git config --global user.name "Allan Niles"
    git config --global user.email "allancoding.dev@gmail.com"
    Set-Location "C:\Users\student\Documents\SoftwareDev"
    $setwallpapersrc = @"
    using System.Runtime.InteropServices;
    public class Wallpaper
    {
    public const int SetDesktopWallpaper = 20;
    public const int UpdateIniFile = 0x01;
    public const int SendWinIniChange = 0x02;
    [DllImport("user32.dll", SetLastError = true, CharSet = CharSet.Auto)]
    private static extern int SystemParametersInfo(int uAction, int uParam, string lpvParam, int fuWinIni);
    public static void SetWallpaper(string path)
    {
        SystemParametersInfo(SetDesktopWallpaper, 0, path, UpdateIniFile | SendWinIniChange);
    }
    }
"@
    Add-Type -TypeDefinition $setwallpapersrc
    [Wallpaper]::SetWallpaper("C:\Users\student\Documents\SoftwareDev\wallpaper.jpg")
    Set-Content -Path "C:\Users\student\AppData\Roaming\Code\User\settings.json" -Value "{}"
    $vscode = "/c start """" ""C:\Users\student\AppData\Local\Programs\Microsoft VS Code\Code.exe"" ""."" && exit"
    Start-Process -FilePath CMD.exe -ArgumentList $vscode
    winget install -e --id 7zip.7zip
    winget install OpenJS.NodeJS
    winget install -e --id Yarn.Yarn
    winget install ffmpeg
    # winget install -e --id Python.Python.3.11 --scope machine
    winget install --id=Microsoft.VCRedist.2015+.x64  -e
    winget install -e -i --id=9PC6682RJCDD --source=msstore --accept-package-agreements --accept-source-agreements
    Start-Process cmd -ArgumentList "/c", "npm install --global yarn"
    exit
}