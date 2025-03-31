<?php

use PhpParser\Node\Stmt\Static_;

class classname{
    function __construct($param){
        echo 'Constructor called with a parameter ' .$param. '.<br />';
    }
}

$a = new classname('First');
$b = new classname('Second');

// $c = new classname(); // this will result to error message because there's no argument passed to the constructor of the Class.

// Accessor function of the Class.
class AccessorClass{
    
    private $attribute;
    
    function __get($param){
        return $this->$param;
    }
    
    function __set($param, $value) {
        return $this->$param = $value;
    }
}

$accessor = new AccessorClass();

echo $accessor->attribute = 10;
echo $accessor->attribute;

// End of Accessor function of the Class.

// Implementing Interface
interface Display{
    function display();
}

class DisplayClass implements Display{
    function display(){
        echo "Displaying the Interface function.";
    }
}

$displayClass = new DisplayClass();

// End of Implementing Interface

// Late Static Binding
echo "<p>";
class A{
    public static function whichclass(){
        echo __CLASS__;
    }
    
    public static function test(){
        self::whichclass();
    }
}

class B extends A{
    public static function whichclass(){
        echo __CLASS__;
    }
}

A::test();
B::test();

echo "</p>";
// End of Late Static Binding


?>