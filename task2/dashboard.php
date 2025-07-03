<?php
session_start();
if (!isset($_SESSION['user'])) {
    die("Access denied. Please login.");
}
echo "Welcome, " . $_SESSION['user'];
?>
