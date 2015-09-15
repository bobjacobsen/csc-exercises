<?php
$file = fopen("log.txt","a");
$_GET["IP"] = $_SERVER['REMOTE_ADDR'];
$_GET["REMOTE_HOST"] = $_SERVER['REMOTE_HOST'];
$_GET["DATE"] = date("Y-m-d H:i:s");

fwrite($file,print_r($_GET, true), 500);
fclose($file);
?>
