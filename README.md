# **Coupon Service — v1 (Read-Only)**

### **Purpose**

* List all coupons
* Get coupon by ID (masked code unless requester purchased)

### **Entity (Coupon)**

* `id: Long`
* `code: String` — coupon code
* `desc: String`
* `amount: Decimal`
* `purchasedBy: Long | null 

### **API**

1. **Get All Coupons**
   Show Masked Code

3. **Get Coupon by ID**

Rules:
- If purchasedBy == userId → show full code
- Else → show masked code (******1234)
