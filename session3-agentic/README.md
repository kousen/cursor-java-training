# Session 3: Agentic Coding Solutions

This directory will contain the solution implementation for Session 3 lab exercises.

## Project Structure

```
session3-agentic/
├── README.md              # This file
├── ecommerce-modular/     # Modular architecture solution
└── ecommerce-monolith/    # Starter monolithic app (if needed)
```

## Agentic Coding Project

This project demonstrates:
- Extended Thinking mode for complex problem analysis
- Plan Mode for multi-phase architectural changes
- Modular architecture extraction from monolith
- Custom slash commands for team workflows
- Model Context Protocol (MCP) integration basics
- AI-assisted code review and refactoring

## Prerequisites

- Cursor with Plan Mode features enabled
- Extended Thinking mode available
- Java 17 or 21
- Spring Boot 3.2+
- Docker (optional, for local services)

## How to Run

**Note:** This session requires Cursor's Plan Mode and Extended Thinking features. 

1. **Navigate to project:**
   ```bash
   cd ecommerce-modular  # or ecommerce-monolith
   ```

2. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

3. **Test endpoints:**
   - User module: http://localhost:8080/api/users
   - Product module: http://localhost:8081/api/products
   - Order module: http://localhost:8082/api/orders

## Technologies Used

- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- H2 Database (or PostgreSQL via Docker)
- Modular monolith architecture

## Lab Exercises

This solution implements exercises from [Agentic Lab Exercises](../agentic_labs.md):

- ⏳ Lab 0: Agentic Coding Setup (requires Extended Thinking mode)
- ⏳ Lab 1: Modular Architecture Planning (requires Plan Mode)
- ⏳ Lab 2: Service Extraction
- ⏳ Lab 3: Shared Library Creation
- ⏳ Lab 4: Custom Slash Commands
- ⏳ Lab 5: MCP Integration (requires MCP setup)
- ⏳ Lab 6: AI Code Review
- ⏳ Lab 7: Team Collaboration

## Cursor Features Required

**Essential:**
- ✅ Chat Mode (Cmd/Ctrl+L)
- ✅ Agent Mode / Composer (Cmd/Ctrl+I or Cmd/Ctrl+Shift+I)
- ⚠️ Extended Thinking mode (check availability)
- ⚠️ Plan Mode (check availability)

**Optional:**
- MCP integration
- Custom slash commands

## Notes

- **Plan Mode Availability:** Verify Plan Mode is available in your Cursor version
- **Extended Thinking:** May take longer but provides deeper analysis
- **Modular Architecture:** Each module should be independently buildable
- **Gradual Refactoring:** Plan Mode allows phased execution

## Verification Status

⚠️ **Pending Full Validation:**
- Requires Plan Mode features in Cursor
- Requires Extended Thinking mode
- Requires monolithic starter application
- Requires MCP setup for Lab 5

**Lab Instructions Validated:** ✅ All instructions reviewed and appear complete

## Next Steps

1. Verify Plan Mode availability in Cursor
2. Create monolithic e-commerce starter app
3. Test Extended Thinking mode analysis
4. Execute modular refactoring plan
5. Complete all labs with Plan Mode

---

*Status: Instructions validated, full implementation pending Plan Mode verification*

