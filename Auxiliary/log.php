<?php
/* This script handles CSC logging requests to the server and writes them to a local file */
$file = fopen("log.txt","a");

/* _GET has the original request, to which we add some additional information */
$_GET["IP"] = $_SERVER['REMOTE_ADDR'];
$_GET["REMOTE_HOST"] = $_SERVER['REMOTE_HOST'];
date_default_timezone_set("UTC");               /* llog time in UTC */
$_GET["DATE"] = date("Y-m-d H:i:s");

fwrite($file,print_r($_GET, true), 500);        /* limited to 500 chars per request */
fclose($file);
?>
