# Pre-Flight Checklist: Before Running Through Everything

This document identifies potential issues and improvements before you do a final walkthrough.

## ✅ What Looks Great

1. **Session 1 is solid** - Fully validated, tested, documented
2. **Documentation structure** - Well organized with clear READMEs
3. **Lab instructions** - Clear and comprehensive
4. **Repository organization** - Clean monorepo structure

## ⚠️ Potential Issues & Recommendations

### 1. Multiple Summary/Documentation Files ✅ RESOLVED

**Status:** Cleaned up
- ✅ Removed duplicate `PROJECT_CONTEXT.md` from root (kept `.cursor/PROJECT_CONTEXT.md`)
- ✅ Consolidated summaries into `docs/SESSION_SUMMARIES.md`
- ✅ Removed `SESSION1_SUMMARY.md`, `SESSION2_SUMMARY.md`, `SESSION2_MATERIALS_COMPLETE.md`
- ✅ All documentation now in `docs/` folder

### 2. Session 1 Solution Location (Minor)

**Current:** `session1-spring-boot/hello-spring/`  
**Status:** ✅ Complete and working

**Note:** Make sure students know they can reference this as a solution without copying it directly.

### 3. Session 2 Android Project (Needs Attention)

**Current:** `session2-android/TaskManagerApp/` structure exists but no implementation  
**Issue:** Lab instructions validated, but no actual working code

**What to verify when you run through:**
- Android Studio setup works
- Composer mode with `@codebase` tag works as documented
- All prompts generate expected code
- Hybrid workflow (Cursor ↔ Android Studio) is smooth
- All labs can be completed as written

### 4. Missing PetClinic Clone Instructions (Minor)

**Issue:** Labs reference Spring PetClinic but setup instructions could be clearer

**Current state:**
- `petclinic-guide.md` exists (good!)
- Main README mentions cloning
- But no explicit "Lab 0 for PetClinic" setup

**Recommendation:** Consider adding a note in `labs.md` Lab 6 that students should clone PetClinic before the exploration starts.

### 5. Java Version Handling (Already Addressed)

✅ **Good:** Java 25+ compatibility issues documented  
✅ **Good:** Troubleshooting added to labs, outline, and slides  
✅ **Good:** Session 1 README has Java version notes

**No action needed** - this is already well documented.

### 6. Build Artifacts in Session 1 (Should be Ignored)

**Status:** ✅ `build/` is in `.gitignore`  
**Note:** The `session1-spring-boot/hello-spring/build/` directory exists locally but should be ignored by git.

**Recommendation:** Verify build artifacts aren't committed (they shouldn't be with current `.gitignore`).

### 7. Slidev Presentation Files

**Question:** Are slides ready to present?
- `slides.md` - Session 1
- `android_slides.md` - Session 2
- `agentic_slides.md` - Session 3
- `testing_slides.md` - Session 4
- `agents_slides.md` - Session 5

**Recommendation:** 
- Do a quick slidev review to ensure no code blocks exceed 12 lines
- Check that v-clicks don't exceed 4 items
- Verify all slides fit in viewport

### 8. Session Status Inconsistencies

**In README.md:**
- Sessions 1-2 marked as ✅ (complete)
- Sessions 3-5 marked as ✅ but note "instructions validated, full implementation pending"

**Issue:** The ✅ checkmark might imply completeness when Sessions 3-5 need implementation.

**Recommendation:** Consider using different status indicators:
- ✅ = Fully validated and tested
- ⚠️ = Instructions validated, implementation pending
- 📝 = Materials complete, needs validation

### 9. Lab File Names

**Current:** Good separation
- `labs.md` - Session 1
- `android_labs.md` - Session 2
- `agentic_labs.md` - Session 3
- `testing_labs.md` - Session 4
- `agents_labs.md` - Session 5

**Status:** ✅ No issues, clear naming.

### 10. Cursor Quick Start Guide

**Status:** ✅ `cursor-quickstart-for-intellij-users.md` exists  
**Note:** Make sure this is prominently linked/referenced in Session 1 materials.

**Current:** It's in Session 1 materials list in README ✅

## 🔍 What to Test When Running Through

### Session 1 Checklist
- [ ] Start from scratch following `labs.md`
- [ ] Verify Spring Initializr prompts work
- [ ] Test all AI prompts as written
- [ ] Verify Java version compatibility handling
- [ ] Run all tests and verify they pass
- [ ] Check H2 console access works
- [ ] Verify PetClinic clone and exploration

### Session 2 Checklist (When Android Studio Available)
- [ ] Create project from scratch
- [ ] Verify Composer mode with `@codebase` works
- [ ] Test hybrid workflow (Cursor ↔ Android Studio)
- [ ] Generate all code following prompts exactly
- [ ] Verify app runs on emulator/device
- [ ] Test all navigation flows
- [ ] Verify Room database persistence
- [ ] Run all tests

### Sessions 3-5 (When Features Available)
- [ ] Verify Cursor Plan Mode availability
- [ ] Test Extended Thinking mode
- [ ] Verify MCP setup process
- [ ] Test all advanced features mentioned

## 📋 Quick Wins Before Testing

1. **Consolidate documentation** - Move or consolidate `*_SUMMARY.md` files
2. **Add PetClinic setup note** - Small addition to Lab 6 in `labs.md`
3. **Review slidev files** - Quick code block length check
4. **Verify .gitignore** - Make sure build artifacts aren't committed
5. **Update status indicators** - Consider clearer status for Sessions 3-5

## 🎯 Critical Before First Class

### Must Have Working:
- ✅ Session 1 solution (`session1-spring-boot/hello-spring/`)
- ✅ Session 1 labs (`labs.md`)
- ✅ Session 1 slides (`slides.md`)
- ✅ Session 1 outline (`session1-outline.md`)

### Should Test:
- All Session 1 prompts with fresh Cursor session
- Spring Initializr integration
- Test generation quality
- PetClinic exploration flow

### Nice to Have:
- Session 2 implementation for reference
- Quick reference cards for common prompts
- Troubleshooting FAQ

## 🚀 Ready to Go?

**Session 1:** ✅ YES - Ready for immediate use

**Overall Assessment:** The project is in excellent shape. Main remaining work is:
1. Validating Session 2 with actual Android Studio
2. Implementing Sessions 3-5 when features available
3. Minor documentation cleanup (optional)

**Bottom Line:** You can confidently teach Session 1 right now. For Sessions 2-5, follow the lab instructions when you have the environments/features available.

---

*Generated: Pre-flight review*
*Next: Run through Session 1 to verify everything works as documented*

