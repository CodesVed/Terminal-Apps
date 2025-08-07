$toolsDir   = "$(Split-Path -parent $MyInvocation.MyCommand.Definition)"
$jarPath    = Join-Path $toolsDir "guess-it.jar"

Start-Process -FilePath "java.exe" -ArgumentList "-jar `"$jarPath`"" -NoNewWindow -Wait
