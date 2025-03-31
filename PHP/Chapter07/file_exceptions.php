<?php

class fileOpenException extends Exception{
    function __toString(){
        return "fileOpenException " .$this->getCode().
                ": " .$this->getMessage()."<br/>" . " in "
                .$this->getFile(). " on line " .$this->getLine().
                "<br/>";
    }
} // End of class fileOpenException extends Exception

class fileWriteException extends Exception{
    function __toString(){
        return "fileWriteException " .$this->getCode().
        ": " .$this->getMessage()."<br/>" . " in "
            .$this->getFile(). " on line " .$this->getLine().
            "<br/>";
    }
} // End of class fileWriteException extends Exception

class fileLockException extends Exception{
    function __toString(){
        return "fileLockException " .$this->getCode().
        ": " .$this->getMessage()."<br/>" . " in "
            .$this->getFile(). " on line " .$this->getLine().
            "<br/>";
    }
} // End of class fileLockException extends Exception

?>