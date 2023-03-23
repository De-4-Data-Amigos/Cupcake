<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Card</title>
</head>
<body>
<div class="card bg-primary text-white rounded-3">
    <div class="card-body">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h5 class="mb-0">Card details</h5>
            <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp" class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
        </div>
        <p class="small mb-2">Card type</p>
        <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-mastercard fa-2x me-2"></i></a>
        <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-visa fa-2x me-2"></i></a>
        <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-amex fa-2x me-2"></i></a>
        <a href="#!" type="submit" class="text-white"><i class="fab fa-cc-paypal fa-2x"></i></a>

        <form class="mt-4">
            <div class="form-outline form-white mb-4">
                <input type="text" id="typeName" class="form-control form-control-lg" siez="17" placeholder="Cardholder's Name">
                <label class="form-label" for="typeName" style="margin-left: 0px;">Cardholder's Name</label>
                <div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div><div class="form-notch-middle" style="width: 117.6px;"></div><div class="form-notch-trailing"></div></div></div>

            <div class="form-outline form-white mb-4">
                <input type="text" id="typeText" class="form-control form-control-lg" siez="17" placeholder="1234 5678 9012 3457" minlength="19" maxlength="19">
                <label class="form-label" for="typeText" style="margin-left: 0px;">Card Number</label>
                <div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div><div class="form-notch-middle" style="width: 84.8px;"></div><div class="form-notch-trailing"></div></div></div>

            <div class="row mb-4">
                <div class="col-md-6">
                    <div class="form-outline form-white">
                        <input type="text" id="typeExp" class="form-control form-control-lg" placeholder="MM/YYYY" size="7" minlength="7" maxlength="7">
                        <label class="form-label" for="typeExp" style="margin-left: 0px;">Expiration</label>
                        <div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div><div class="form-notch-middle" style="width: 64.8px;"></div><div class="form-notch-trailing"></div></div></div>
                </div>
                <div class="col-md-6">
                    <div class="form-outline form-white">
                        <input type="password" id="typeText" class="form-control form-control-lg" placeholder="●●●" size="1" minlength="3" maxlength="3">
                        <label class="form-label" for="typeText" style="margin-left: 0px;">Cvv</label>
                        <div class="form-notch"><div class="form-notch-leading" style="width: 9px;"></div><div class="form-notch-middle" style="width: 30.4px;"></div><div class="form-notch-trailing"></div></div></div>
                </div>
            </div>

        </form>

        <hr class="my-4">

        <div class="d-flex justify-content-between">
            <p class="mb-2">Subtotal</p>
            <p class="mb-2">$4798.00</p>
        </div>

        <div class="d-flex justify-content-between">
            <p class="mb-2">Shipping</p>
            <p class="mb-2">$20.00</p>
        </div>

        <div class="d-flex justify-content-between mb-4">
            <p class="mb-2">Total(Incl. taxes)</p>
            <p class="mb-2">$4818.00</p>
        </div>

</body>
</html>
