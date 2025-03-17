<?php
class Exception
{
    protected $message = 'Unknown exception';   // exception message
    private   $string;                          // __toString cache
    protected $code = 0;                        // user defined exception code
    protected $file;                            // source filename of exception
    protected $line;                            // source line of exception
    private   $trace;                           // backtrace
    private   $previous;                        // previous exception if nested exception

public function __construct($message = null, $code = 0, Exception $previous = null) {
    $this->message = $message;
    $this->code = $code;
    $this->previous = $previous;
}

    final private function __clone() {}         // Inhibits cloning of exceptions.

    final public  function getMessage() {       // message of exception
        return $this->message;
    }
    final public  function getCode() {          // code of exception
        return $this->code;
    }
    final public  function getFile() {          // source filename
        return $this->file;
    }
    final public  function getLine() {          // source line
        return $this->line;
    }
    final public  function getTrace() {         // an array of the backtrace()
        return $this->trace;
    }
    final public  function getPrevious() {      // previous exception
        return $this->previous;
    }
    final public  function getTraceAsString() { // formatted string of trace
        return implode("\n", $this->trace);
    }

    /* Overrideable */
    public function __toString() {              // formatted string for display
        return (string) $this->getMessage();
    }
}
?>