# ntfy Android - Authentication Fixed Build

## What's Fixed
🔒 **Fixed the authentication bug that prevented adding users in the web interface**

The original ntfy web interface had a bug where it would fail to create users with the error:
```
Expected ',' or '}' after property value in JSON at position 49
```

This was caused by incorrect JSON formatting in the user creation request. This build fixes that issue.

## Changes Made
- Fixed JSON formatting in `server/static/app.html`
- Removed trailing comma after `role` property in user creation request
- Tested and verified user creation works properly

## Installation
1. Download `ntfy-auth-fixed.apk`
2. Enable "Install from unknown sources" on your Android device
3. Install the APK
4. Configure with your ntfy server URL

## Build Info
- Based on: ntfy latest (October 2025)
- Build Date: $(date -u)
- Platform: Android (F-Droid variant)
- Signed: Yes (Barrer Software)

## Server Configuration
This APK works with the patched ntfy server. Make sure your server has the authentication fix applied.

---
**Built by Barrer Software** - Fixing shit that should have been fixed already
