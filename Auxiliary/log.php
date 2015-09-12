<?php
$file = fopen("log.txt","a");
$_GET["IP"] = $_SERVER['REMOTE_ADDR'];
$_GET["HOST"] = $_SERVER['REMOTE_HOST'];

fwrite($file,print_r($_GET, true), 500);
fclose($file);
?>
