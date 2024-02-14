let navbar = document.querySelector('.navbar');

document.querySelector('#menu-btn').onclick = () => {
    navbar.classList.toggle('active');
}

window.onscroll = () => {
    navbar.classList.remove('active');
}

let slides = document.querySelectorAll('.home .slides-container .slide');
let index = 0;

function next() {
    slides[index].classList.remove('active');
    index = (index + 1) % slides.length;
    slides[index].classList.add('active');
}

function prev() {
    slides[index].classList.remove('active');
    index = (index - 1 + slides.length) % slides.length;
    slides[index].classList.add('active');
}

//        seacrch script
let search = document.querySelector('.search');
document.querySelector('#search').onclick = () => {
    search.classList.toggle('active');
};

//cart script
function openCartPopup() {
    // AJAX request to load cart_test.jsp content
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("cart-content").innerHTML = this.responseText;
            document.getElementById("cart-popup").style.display = "block";
        }
    };
    xhttp.open("GET", "cart_test.jsp", true);
    xhttp.send();
}

function closeCartPopup() {
    document.getElementById("cart-popup").style.display = "none";
}

var cartItems = []; // Array to store item IDs

function addItemToCart(itemId) {
    // Check if the item is already in the cart
    if (!cartItems.includes(itemId)) {
        cartItems.push(itemId); // Add item ID to the array
        updateCartCount(); // Update the cart count display
    }
}

// Function to update the cart count display
function updateCartCount() {
    var cartCountElement = document.getElementById("cart-count");
    if (cartCountElement) {
        cartCountElement.textContent = cartItems.length; // Update the cart count
    }
}

// Function to send item IDs to servlet when "Cart" link is clicked
document.getElementById("cart-link").addEventListener("click", function () {
    // Convert the array to a comma-separated string
    var itemIdsString = cartItems.join(",");
    // Redirect to the servlet with the item IDs as a query parameter
    window.location.href = "/mavenproject1/AddToCart?action=GET&act=viewcart&itemIds=" + itemIdsString;
});