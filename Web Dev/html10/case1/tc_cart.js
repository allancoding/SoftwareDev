"use strict";

/*
   New Perspectives on HTML5 and CSS3, 8th Edition
   Tutorial 10
   Case Problem 1

   Author: Allan Niles
   Date:   11/4/2024
   
   Filename: tc_cart.js
	
*/

// Initialize the total order amount to 0
var orderTotal = 0;
// Initialize the HTML for the cart table with headers
var cartHTML = "<table> <tr> <th>Item</th><th>Description</th><th>Price</th><th>Qty</th><th>Total</th> </tr>";

// Loop through each item in the cart
for (var i = 0; i < item.length; i++) {
    // Add a row for the item image
    cartHTML += "<tr> <td><img src='tc_" + item[i] + ".png' alt='item' /></td>";
    // Add a row for the item description, price, and quantity
    cartHTML += "<td>" + itemDescription[i] + "</td> <td>$" + itemPrice[i] + "</td> <td>" + itemQty[i] + "</td>";
    // Calculate the total cost for the item
    var itemCost = itemPrice[i] * itemQty[i];
    // Add a row for the total cost of the item
    cartHTML += "<td>$" + itemCost + "</td></tr>";
    // Add the item cost to the total order amount
    orderTotal += itemCost;
}

// Add a row for the subtotal of the order
cartHTML += "<tr> <td colspan='4'>Subtotal</td> <td>$" + orderTotal + "</td> </tr> </table>";
// Insert the cart HTML into the element with the ID 'cart'
document.getElementById("cart").innerHTML = cartHTML;