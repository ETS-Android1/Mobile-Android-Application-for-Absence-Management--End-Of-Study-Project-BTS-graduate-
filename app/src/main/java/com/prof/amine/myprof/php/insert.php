<?php
include("HelperMySQL.php");
$query="INSERT INTO `tablePFE` (`ID`, `TEXT`) VALUES (NULL, 'salam') ";
mysqli_query($cn,$query);


?>