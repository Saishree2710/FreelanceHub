const getStartedBtn = document.getElementById("getStartedBtn");

getStartedBtn.addEventListener("click", function () {
    document.getElementById("register").scrollIntoView({
        behavior: "smooth"
    });
});


// =========================
// REGISTER
// =========================

const registerForm = document.getElementById("registerForm");
const registerMessage = document.getElementById("registerMessage");

registerForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;
    const skills = document.getElementById("skills").value;
    const experience = document.getElementById("experience").value;
    const rating = document.getElementById("rating").value;

    registerMessage.textContent = "Registering user...";

    const soapRequest =
        `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                          xmlns:usr="http://freelancehub.com/users">
            <soapenv:Header/>
            <soapenv:Body>
                <usr:registerUserRequest>
                    <usr:name>${escapeXml(name)}</usr:name>
                    <usr:email>${escapeXml(email)}</usr:email>
                    <usr:password>${escapeXml(password)}</usr:password>
                    <usr:role>${escapeXml(role)}</usr:role>
                    <usr:skills>${escapeXml(skills)}</usr:skills>
                    <usr:experience>${experience}</usr:experience>
                    <usr:rating>${rating}</usr:rating>
                </usr:registerUserRequest>
            </soapenv:Body>
        </soapenv:Envelope>`;

    console.log("Sending SOAP request:");
    console.log(soapRequest);

    try {

        const response = await fetch("/ws", {
            method: "POST",

            headers: {
                "Content-Type": "text/xml; charset=utf-8"
            },

            body: soapRequest
        });

        const responseText = await response.text();

        console.log("SOAP response:");
        console.log(responseText);

        if (!response.ok) {
            throw new Error(
                "SOAP request failed. HTTP status: " + response.status
            );
        }

        if (responseText.includes("User registered successfully")) {

            registerMessage.textContent =
                "User registered successfully!";

            registerForm.reset();

        } else {

            registerMessage.textContent =
                "Registration failed.";

        }

    } catch (error) {

        console.error("Error:", error);

        registerMessage.textContent =
            "Error: " + error.message;
    }
});


// =========================
// LOGIN
// =========================

const loginBtn = document.getElementById("loginBtn");
const loginForm = document.getElementById("loginForm");
const loginMessage = document.getElementById("loginMessage");


// Scroll to login section when navbar Login button is clicked
loginBtn.addEventListener("click", function () {

    document.getElementById("login").scrollIntoView({
        behavior: "smooth"
    });

});


// Submit login form
loginForm.addEventListener("submit", async function (event) {

    event.preventDefault();

    const email = document.getElementById("loginEmail").value;
    const password = document.getElementById("loginPassword").value;

    loginMessage.textContent = "Logging in...";

    const soapRequest =
        `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                          xmlns:usr="http://freelancehub.com/users">
            <soapenv:Header/>
            <soapenv:Body>
                <usr:loginUserRequest>
                    <usr:email>${escapeXml(email)}</usr:email>
                    <usr:password>${escapeXml(password)}</usr:password>
                </usr:loginUserRequest>
            </soapenv:Body>
        </soapenv:Envelope>`;

    console.log("Sending login SOAP request:");
    console.log(soapRequest);

    try {

        const response = await fetch("/ws", {
            method: "POST",

            headers: {
                "Content-Type": "text/xml; charset=utf-8"
            },

            body: soapRequest
        });

        const responseText = await response.text();

        console.log("SOAP login response:");
        console.log(responseText);

        if (!response.ok) {

            throw new Error(
                "SOAP login failed. HTTP status: " + response.status
            );

        }

        // Check for successful login
        if (responseText.includes("success>true")) {

            const nameMatch =
                responseText.match(/<[^>]*name>(.*?)<\/[^>]*name>/);

            const roleMatch =
                responseText.match(/<[^>]*role>(.*?)<\/[^>]*role>/);

            const name =
                nameMatch ? nameMatch[1] : "";

            const role =
                roleMatch ? roleMatch[1] : "";

            loginMessage.textContent =
                "Login successful! Welcome " +
                name +
                " (" +
                role +
                ")";

            loginForm.reset();

        } else {

            loginMessage.textContent =
                "Invalid email or password.";

        }

    } catch (error) {

        console.error("Login error:", error);

        loginMessage.textContent =
            "Error: " + error.message;
    }
});


// =========================
// XML ESCAPING
// =========================

function escapeXml(value) {

    return value
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&apos;");
}