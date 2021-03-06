<?php
//
// A very simple PHP example that sends a HTTP POST to a remote site
//

$ch = curl_init();

curl_setopt($ch, CURLOPT_URL,"http://localhost/feedback");
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS,
            "postvar1=value1&postvar2=value2");

// In real life you should use something like:
// curl_setopt($ch, CURLOPT_POSTFIELDS, 
//          http_build_query(array('postvar1' => 'value1')));

// Receive server response ...
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$server_output = curl_exec($ch);

curl_close ($ch);

// Further processing ...
if ($server_output == "OK") { ... } else { ... }
?>