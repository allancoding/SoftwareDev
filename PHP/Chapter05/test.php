<?php

// helper function
function var_arg(){
    echo 'Number of parameters: ' . func_num_args();
    
    echo '<br />';
    $args = func_get_args();
    foreach ($args as $arg){
        echo $arg. '<br>';
    }
}

var_arg(1, 'striing', 'values');
?>